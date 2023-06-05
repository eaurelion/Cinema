package edu.school21.cinema.models.dao;

import edu.school21.cinema.models.CinemaSession;
import lombok.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
public class CinemaSessionDao {
    private Long id;
    private String dateTime;
    private MovieDao movieDao;

    public CinemaSessionDao(CinemaSession cinemaSession) {
        this.id = cinemaSession.getId();
        LocalDateTime dateTimeTmp = cinemaSession.getDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm");
        this.dateTime = dateTimeTmp.format(formatter);
        movieDao = new MovieDao(cinemaSession.getMovie());
    }
}
