package pl.kwojtas.trakkit.service;

import org.springframework.stereotype.Service;
import pl.kwojtas.trakkit.api.v1.mapper.VideoGameMapper;
import pl.kwojtas.trakkit.api.v1.model.VideoGameDTO;
import pl.kwojtas.trakkit.model.VideoGame;
import pl.kwojtas.trakkit.repository.VideoGameRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VideoGameServiceImpl implements VideoGameService {

    private final VideoGameMapper mapper;
    private final VideoGameRepository repository;

    public VideoGameServiceImpl(VideoGameMapper mapper, VideoGameRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public List<VideoGameDTO> getAllVideoGames() {
        return repository.findAll().stream()
                .map(mapper::videoGameToVideoGameDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VideoGameDTO getVideoGameById(Long id) {
        Optional<VideoGame> videoGameOptional = repository.findById(id);
        if (!videoGameOptional.isPresent()) {
            throw new RuntimeException("Cannot find video game with ID=" + id);
        }
        return mapper.videoGameToVideoGameDTO(videoGameOptional.get());
    }
}
