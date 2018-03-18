package pl.kwojtas.trakkit.repository;

import org.springframework.data.repository.CrudRepository;
import pl.kwojtas.trakkit.model.VideoGameStatus;

public interface VideoGameStatusRepository extends CrudRepository<VideoGameStatus, Long> {
}
