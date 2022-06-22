package assessment.userservice.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address_type", schema = "dbo", catalog = "postgres")
public class AddressType {

	@Column(name = "address_type", nullable = false, length = 8)
	@Id
	private String addressType;
	
	@Column(name = "description", nullable = true, length = 32)
	private String description;

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "AddressType [addressType=" + addressType + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressType, description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressType other = (AddressType) obj;
		return Objects.equals(addressType, other.addressType) && Objects.equals(description, other.description);
	}
	
}
