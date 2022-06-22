package assessment.userservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assessment.userservice.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
