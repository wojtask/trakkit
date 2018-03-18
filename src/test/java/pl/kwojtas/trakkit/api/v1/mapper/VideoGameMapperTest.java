package pl.kwojtas.trakkit.api.v1.mapper;

import org.junit.Test;
import pl.kwojtas.trakkit.api.v1.model.VideoGameDTO;
import pl.kwojtas.trakkit.model.VideoGame;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class VideoGameMapperTest {

    private VideoGameMapper mapper = VideoGameMapper.INSTANCE;

    private static final String TITLE = "Far Cry";
    private static final String DEVELOPER = "Crytek";
    private static final String PUBLISHER = "Ubisoft";
    private static final LocalDate DATE_RELEASED = LocalDate.of(2004, Month.MARCH, 23);

    @Test
    public void shouldMapVideoGameToVideoGameDTO() {
        VideoGame videoGame = new VideoGame();
        videoGame.setId(2L);
        videoGame.setTitle(TITLE);
        videoGame.setDeveloper(DEVELOPER);
        videoGame.setPublisher(PUBLISHER);
        videoGame.setDateReleased(DATE_RELEASED);

        VideoGameDTO videoGameDTO = mapper.videoGameToVideoGameDTO(videoGame);

        assertThat(videoGameDTO.getId(), equalTo(2L));
        assertThat(videoGameDTO.getTitle(), equalTo(TITLE));
        assertThat(videoGameDTO.getDeveloper(), equalTo(DEVELOPER));
        assertThat(videoGameDTO.getPublisher(), equalTo(PUBLISHER));
        assertThat(videoGameDTO.getDateReleased(), equalTo(DATE_RELEASED));
    }

}