package pl.kwojtas.trakkit.api.v1.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class VideoGameDTO {
    Long id;
    String title;
    String developer;
    String publisher;
    String summary;
    LocalDate dateReleased;
}
