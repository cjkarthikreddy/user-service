package assessment.userservice.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assessment.userservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public Slice<User> findByLastName(String lastName, Pageable pageable);
	
	public Slice<User> findByAge(Integer age, Pageable pageable);
	
	public Slice<User> findByLastNameAndAge(String lastName, Integer age, Pageable pageable);
	
}
