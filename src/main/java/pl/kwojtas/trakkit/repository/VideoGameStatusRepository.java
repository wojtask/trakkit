package pl.kwojtas.trakkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kwojtas.trakkit.model.VideoGameStatus;

public interface VideoGameStatusRepository extends JpaRepository<VideoGameStatus, Long> {
}
