package assessment.userservice.service;

import assessment.userservice.model.UserListWrapper;
import assessment.userservice.model.User;

public interface UserService {
	
	public UserListWrapper getUsers(String lastName, int age, int pageNumber,
			String sortKey, String sortDirection);
	
	public User getUserById(Integer userId);

}
