package cl.securityApp.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cl.securityApp.web.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	User findUserByUsername(String username);

}
