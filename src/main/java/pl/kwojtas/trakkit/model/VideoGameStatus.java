package pl.kwojtas.trakkit.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
public class VideoGameStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(optional = false)
    private User user;

    @OneToOne(optional = false)
    private VideoGame videoGame;

    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull
    private LocalDateTime timestamp;

}
