package pl.kwojtas.trakkit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kwojtas.trakkit.model.VideoGame;

public interface VideoGameRepository extends JpaRepository<VideoGame, Long> {
}
