package assessment.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assessment.userservice.entity.AddressType;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, String> {

}
