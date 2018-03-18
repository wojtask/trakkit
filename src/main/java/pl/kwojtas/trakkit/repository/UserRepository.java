package pl.kwojtas.trakkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kwojtas.trakkit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
