package pl.kwojtas.trakkit.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kwojtas.trakkit.model.VideoGame;

public interface VideoGameRepository extends CrudRepository<VideoGame, Long> {
}
