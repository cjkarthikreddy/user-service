package assessment.userservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User implements Serializable {

	private static final long serialVersionUID = -3146113424704991008L;

	@JsonProperty("userId")
	private Integer userId;
	
	@JsonProperty("firstName")
	private String firstName;
	
	@JsonProperty("lastName")
	private String lastName;
	
	@JsonProperty("age")
	private Integer age;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("homeAddress")
	private Address homeAddress;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonProperty("workAddress")
	private Address workAddress;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}

	public Address getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(Address workAddress) {
		this.workAddress = workAddress;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", homeAddress=" + homeAddress + ", workAddress=" + workAddress + "]";
	}

}
