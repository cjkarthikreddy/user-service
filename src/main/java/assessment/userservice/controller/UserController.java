package assessment.userservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import assessment.userservice.model.UserListWrapper;
import assessment.userservice.model.User;
import assessment.userservice.service.UserService;

@RestController("/")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@GetMapping("/users")
	public ResponseEntity<UserListWrapper> getUsers(@RequestParam(name = "lastName", required = false) String lastName,
			@RequestParam(name = "age", required = false) Integer age,
			@RequestParam(name = "pageNumber", required = false) Integer pageNumber,
			@RequestParam(name = "sortKey", required = false) String sortKey,
			@RequestParam(name = "sortDirection", required = false) String sortDirection) {
		UserListWrapper userListWrapper = null;
		try {
			 userListWrapper = userService.getUsers(lastName, age==null?-1:age,
					pageNumber==null?0:pageNumber,
					sortKey, sortDirection);
		} catch (Exception e) {
			LOGGER.error("Exception in getting users", e);
			return new ResponseEntity<UserListWrapper>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<UserListWrapper>(userListWrapper, HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable(name = "userId") Integer userId) {
		User user = null;
		try {
			user = userService.getUserById(userId); 
		} catch (Exception e) {
			LOGGER.error("Exception in getting user by given id", e);
			return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
