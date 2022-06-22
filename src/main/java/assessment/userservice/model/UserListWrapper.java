package assessment.userservice.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserListWrapper implements Serializable {

	private static final long serialVersionUID = -7135892505626277595L;
	
	@JsonProperty("users")
	private List<User> users;
	
	@JsonProperty("sliceInfo")
	private SliceInfo sliceInfo;
	
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public SliceInfo getSliceInfo() {
		return sliceInfo;
	}

	public void setSliceInfo(SliceInfo sliceInfo) {
		this.sliceInfo = sliceInfo;
	}

	@Override
	public String toString() {
		return "UserListWrapper [users=" + users + ", sliceInfo=" + sliceInfo + "]";
	}
		
}
