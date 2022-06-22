package assessment.userservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import assessment.userservice.constant.AddressType;
import assessment.userservice.constant.SortDirection;
import assessment.userservice.constant.SortKey;
import assessment.userservice.mapper.AddressMapper;
import assessment.userservice.mapper.UserMapper;
import assessment.userservice.model.SliceInfo;
import assessment.userservice.model.User;
import assessment.userservice.model.UserListWrapper;
import assessment.userservice.repository.UserRepository;
import assessment.userservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final int DEFAULT_PAGE_NUMBER = 0;
	private static final int DEFAULT_PAGE_SIZE = 10;


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private AddressMapper addressMapper;

	public UserListWrapper getUsers(String lastName, int age, int pageNumber,
			String sortKey, String sortDirection) {

		UserListWrapper userListWrapper = new UserListWrapper();
		List<User> users = new ArrayList<>();

		Slice<assessment.userservice.entity.User> userEntitySlice = null;
		// pageable is for soring and filtering
		Pageable pageable = getPageable(pageNumber, DEFAULT_PAGE_SIZE, sortKey, sortDirection);
		if (StringUtils.isNotBlank(lastName) && age >= 0) {
			userEntitySlice = userRepository.findByLastNameAndAge(lastName, age, pageable);
		} else if (StringUtils.isNotBlank(lastName)) {
			userEntitySlice = userRepository.findByLastName(lastName, pageable);
		} else if (age >= 0) {
			userEntitySlice = userRepository.findByAge(age, pageable);
		} else {
			userEntitySlice = userRepository.findAll(pageable);
		}
		
		if (userEntitySlice.getSize() > 0) {
			users = userEntitySlice
					.stream()
					.map(userEntity -> userMapper.mapUser(userEntity))
					.collect(Collectors.toList());

			userListWrapper.setSliceInfo(new SliceInfo(userEntitySlice.getNumber(),
					userEntitySlice.hasPrevious(), 
					userEntitySlice.hasNext()));

		}
		userListWrapper.setUsers(users);
		return userListWrapper;
	}

	@Override
	public User getUserById(Integer userId) {
		assessment.userservice.entity.User userEntity = userRepository.getReferenceById(userId);
		
		if (userEntity == null) {
			return null;
		}
		
		User user = userMapper.mapUser(userEntity);
		List<assessment.userservice.entity.Address> addressEntities = userEntity.getAddresses();
		addressEntities.stream()
		.forEach((addressEntity) -> {
			if (AddressType.HOME.toString().equals(addressEntity.getAddressType())) {
				user.setHomeAddress(addressMapper.mapAddress(addressEntity)); 
			} else if (AddressType.WORK.toString().equals(addressEntity.getAddressType())) {
				user.setWorkAddress(addressMapper.mapAddress(addressEntity)); 
			}
		});

		return user;
	}

	private Pageable getPageable(int pageNumber, int pageSize, String sortKey, String sortDirection) {

		if (pageNumber < 0) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		} 
		// if valid sortKey is not valid then skip sorting
		if (StringUtils.isBlank(sortKey) || !(SortKey.lastName.toString().equals(sortKey) || SortKey.age.toString().equals(sortKey))) {
			return PageRequest.of(pageNumber, pageSize);
		}
		if (SortDirection.ASCENDING.toString().equals(sortDirection)) {
			return PageRequest.of(pageNumber, pageSize, Sort.by(Order.asc(sortKey)));
		} else if (SortDirection.DESCENDING.toString().equals(sortDirection)) {
			return PageRequest.of(pageNumber, pageSize, Sort.by(Order.desc(sortKey)));
		} else {
			return PageRequest.of(pageNumber, pageSize, Sort.by(Order.by(sortKey)));
		}
	}
}
