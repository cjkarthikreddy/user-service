package assessment.userservice.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "address", schema = "dbo", catalog = "postgres")
public class Address {
	
	@Column(name = "address_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer addressId;
	
	@Column(name = "address_line_1", nullable = false, length = 64)
	private String addressLine1;
	
	@Column(name = "address_line_2", nullable = true, length = 64)
	private String addressLine2;
	
	@Column(name = "city", nullable = false, length = 32)
	private String city;
	
	@Column(name = "state", nullable = false, length = 32)
	private String state;
	
	@Column(name = "country", nullable = false, length = 32)
	private String country;
	
	@Column(name = "zip", nullable = false)
	private Integer zip;
	
	@Column(name = "address_type", nullable = false, length = 8)
	private String addressType;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
	private User user;

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}
	
	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", zip=" + zip + ", addressType="
				+ addressType + ", user=" + user + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressId, addressLine1, addressLine2, addressType, city, country, state, user, zip);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(addressLine1, other.addressLine1)
				&& Objects.equals(addressLine2, other.addressLine2) && Objects.equals(addressType, other.addressType)
				&& Objects.equals(city, other.city) && Objects.equals(country, other.country)
				&& Objects.equals(state, other.state) && Objects.equals(user, other.user)
				&& Objects.equals(zip, other.zip);
	}
	
}
