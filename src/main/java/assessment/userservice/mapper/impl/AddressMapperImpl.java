package assessment.userservice.mapper.impl;

import org.springframework.stereotype.Component;

import assessment.userservice.mapper.AddressMapper;
import assessment.userservice.model.Address;

@Component
public class AddressMapperImpl implements AddressMapper {

	@Override
	public Address mapAddress(assessment.userservice.entity.Address addressEntity) {
		Address address = new Address();
		address.setAddressId(addressEntity.getAddressId());
		address.setAddressLine1(addressEntity.getAddressLine1());
		address.setAddressLine2(addressEntity.getAddressLine2());
		address.setCity(addressEntity.getCity());
		address.setState(addressEntity.getState());
		address.setCountry(addressEntity.getCountry());
		address.setZip(addressEntity.getZip());
		address.setAddressType(addressEntity.getAddressType());
		return address;
	}

}
