package edu.school21.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class MovieHall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int seatsCount;
    @JsonIgnore
    @OneToMany(mappedBy = "movieHall", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CinemaSession> sessionList;
}
