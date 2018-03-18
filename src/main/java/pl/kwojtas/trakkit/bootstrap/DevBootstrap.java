package pl.kwojtas.trakkit.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.kwojtas.trakkit.model.Status;
import pl.kwojtas.trakkit.model.User;
import pl.kwojtas.trakkit.model.VideoGame;
import pl.kwojtas.trakkit.model.VideoGameStatus;
import pl.kwojtas.trakkit.repositories.UserRepository;
import pl.kwojtas.trakkit.repositories.VideoGameRepository;
import pl.kwojtas.trakkit.repositories.VideoGameStatusRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private UserRepository userRepository;
    private VideoGameRepository videoGameRepository;
    private VideoGameStatusRepository videoGameStatusRepository;

    public DevBootstrap(UserRepository userRepository,
                        VideoGameRepository videoGameRepository,
                        VideoGameStatusRepository videoGameStatusRepository) {
        this.userRepository = userRepository;
        this.videoGameRepository = videoGameRepository;
        this.videoGameStatusRepository = videoGameStatusRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        User chris = User.builder()
                .username("chris")
                .passwordHash("password")
                .build();

        VideoGame mario = VideoGame.builder()
                .title("Super Mario Bros.")
                .dateReleased(LocalDate.of(1985, Month.SEPTEMBER, 13))
                .developer("Nintendo Creative Department")
                .publisher("Nintendo")
                .summary("In Super Mario Bros., the player controls Mario as he travels through the Mushroom Kingdom " +
                        "to rescue Princess Toadstool from the antagonist, Bowser.")
                .build();

        VideoGame tetris = VideoGame.builder()
                .title("Tetris")
                .dateReleased(LocalDate.of(1984, Month.JUNE, 6))
                .developer("Alexey Pajitnov")
                .publisher("Various")
                .build();

        VideoGameStatus marioBacklog = VideoGameStatus.builder()
                .user(chris)
                .videoGame(mario)
                .status(Status.BACKLOG)
                .timestamp(LocalDateTime.of(2018, Month.MARCH, 18, 0, 0, 0))
                .build();

        VideoGameStatus tetrisBacklog = VideoGameStatus.builder()
                .user(chris)
                .videoGame(tetris)
                .status(Status.BACKLOG)
                .timestamp(LocalDateTime.of(2018, Month.MARCH, 18, 2, 0, 0))
                .build();

        VideoGameStatus marioInProgress = VideoGameStatus.builder()
                .user(chris)
                .videoGame(mario)
                .status(Status.IN_PROGRESS)
                .timestamp(LocalDateTime.of(2018, Month.MARCH, 18, 3, 0, 0))
                .build();

        VideoGameStatus marioCompleted = VideoGameStatus.builder()
                .user(chris)
                .videoGame(mario)
                .status(Status.COMPLETED)
                .timestamp(LocalDateTime.of(2018, Month.MARCH, 18, 21, 37, 20))
                .build();

        userRepository.save(chris);
        videoGameRepository.save(mario);
        videoGameRepository.save(tetris);
        videoGameStatusRepository.save(marioBacklog);
        videoGameStatusRepository.save(tetrisBacklog);
        videoGameStatusRepository.save(marioInProgress);
        videoGameStatusRepository.save(marioCompleted);
    }
}
