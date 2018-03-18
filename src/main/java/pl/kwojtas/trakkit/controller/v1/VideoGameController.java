package pl.kwojtas.trakkit.controller.v1;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kwojtas.trakkit.api.v1.model.VideoGameDTO;
import pl.kwojtas.trakkit.service.VideoGameService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/videogames", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class VideoGameController {

    private VideoGameService videoGameService;

    public VideoGameController(VideoGameService videoGameService) {
        this.videoGameService = videoGameService;
    }

    @GetMapping
    public List<VideoGameDTO> getAllVideoGames() {
        return videoGameService.getAllVideoGames();
    }

    @GetMapping("/{id}")
    public VideoGameDTO getById(@PathVariable Long id) {
        return videoGameService.getVideoGameById(id);
    }

}
