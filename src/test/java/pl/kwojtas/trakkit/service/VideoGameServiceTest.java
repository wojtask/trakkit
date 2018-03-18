package pl.kwojtas.trakkit.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.kwojtas.trakkit.api.v1.mapper.VideoGameMapper;
import pl.kwojtas.trakkit.api.v1.model.VideoGameDTO;
import pl.kwojtas.trakkit.model.VideoGame;
import pl.kwojtas.trakkit.repository.VideoGameRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

public class VideoGameServiceTest {

    private VideoGameService videoGameService;

    @Mock
    private VideoGameRepository videoGameRepository;

    private static final String TITLE = "Contra";

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        videoGameService = new VideoGameServiceImpl(VideoGameMapper.INSTANCE, videoGameRepository);
    }

    @Test
    public void shouldGetAllVideoGames() {
        List<VideoGame> videoGames = Arrays.asList(new VideoGame(), new VideoGame(), new VideoGame());
        when(videoGameRepository.findAll()).thenReturn(videoGames);

        List<VideoGameDTO> videoGameDTOs = videoGameService.getAllVideoGames();

        assertThat(videoGameDTOs, hasSize(3));
    }

    @Test
    public void shouldGetVideoGameById() {
        VideoGame videoGame = new VideoGame();
        videoGame.setId(2L);
        videoGame.setTitle(TITLE);
        when(videoGameRepository.findById(2L)).thenReturn(Optional.of(videoGame));

        VideoGameDTO videoGameDTO = videoGameService.getVideoGameById(2L);

        assertThat(videoGameDTO.getId(), equalTo(2L));
        assertThat(videoGameDTO.getTitle(), equalTo(TITLE));
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotGetVideoGameForNonexistingId() {
        when(videoGameRepository.findById(5L)).thenReturn(Optional.empty());

        videoGameService.getVideoGameById(5L);
    }

}
