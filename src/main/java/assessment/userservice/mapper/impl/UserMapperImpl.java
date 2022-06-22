package assessment.userservice.mapper.impl;

import org.springframework.stereotype.Component;

import assessment.userservice.mapper.UserMapper;
import assessment.userservice.model.User;

@Component
public class UserMapperImpl implements UserMapper {

	public User mapUser(assessment.userservice.entity.User userEntity) {
		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setFirstName(userEntity.getFirstName());
		user.setLastName(userEntity.getLastName());
		user.setAge(userEntity.getAge());
		return user;
	}
	
}
