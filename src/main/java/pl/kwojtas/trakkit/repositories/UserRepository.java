package pl.kwojtas.trakkit.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kwojtas.trakkit.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
