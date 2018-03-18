package pl.kwojtas.trakkit.service;

import pl.kwojtas.trakkit.api.v1.model.VideoGameDTO;

import java.util.List;

public interface VideoGameService {
    List<VideoGameDTO> getAllVideoGames();
    VideoGameDTO getVideoGameById(Long id);
}
