package edu.school21.cinema.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CinemaSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private MovieHall movieHall;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    private Movie movie;
    private int ticketCost;

    public CinemaSession(MovieHall movieHall, Movie movie, LocalDateTime date, int ticketCost) {
        this.movieHall = movieHall;
        this.movie = movie;
        this.date = date;
        this.ticketCost = ticketCost;
    }

    public String getDateHtml() {
        return date.toString().replace('T', ' ');
    }

    public String getDateToEdit() {
        return date.toString();
    }
}
