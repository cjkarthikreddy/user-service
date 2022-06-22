package assessment.userservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address implements Serializable {
	
	private static final long serialVersionUID = 9118947311922031933L;

	@JsonProperty("addressId")
	private Integer addressId;
	
	@JsonProperty("addressLine1")
	private String addressLine1;
	
	@JsonProperty("addressLine2")
	private String addressLine2;
	
	@JsonProperty("city")
	private String city;

	@JsonProperty("state")
	private String state;
	
	@JsonProperty("country")
	private String country;
	
	@JsonProperty("zip")
	private Integer zip;
	
	@JsonProperty("addressType")
	private String addressType;

	
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

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", zip=" + zip + ", addressType="
				+ addressType + "]";
	}
	
}
