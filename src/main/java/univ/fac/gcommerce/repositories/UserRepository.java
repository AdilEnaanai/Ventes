package univ.fac.gcommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import univ.fac.gcommerce.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
    UserDetails findByUsername(String username);
}
