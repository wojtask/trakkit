package pl.kwojtas.trakkit.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import pl.kwojtas.trakkit.api.v1.model.VideoGameDTO;
import pl.kwojtas.trakkit.model.VideoGame;

@Mapper
public interface VideoGameMapper {

    VideoGameMapper INSTANCE = Mappers.getMapper(VideoGameMapper.class);

    VideoGameDTO videoGameToVideoGameDTO(VideoGame videoGame);

}
