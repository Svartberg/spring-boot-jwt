package svartberg.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import svartberg.model.AppMessage;
import svartberg.model.AppUser;

public interface MessageRepository extends JpaRepository<AppMessage, Long> {

  List<AppMessage> findTop10ByUserOrderByIdDesc(AppUser id);
}
