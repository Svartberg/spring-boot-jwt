package svartberg.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import svartberg.model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {

  boolean existsByUsername(String username);

  AppUser findByUsername(String username);

}
