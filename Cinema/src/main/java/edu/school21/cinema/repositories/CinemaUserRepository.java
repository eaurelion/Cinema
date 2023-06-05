package edu.school21.cinema.repositories;

import edu.school21.cinema.models.CinemaUser;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CinemaUserRepository {
    List<CinemaUser> getAll();
    CinemaUser getUserById(Long id);
    CinemaUser getUserByUsername(String username);
    boolean createUser(CinemaUser cinemaUser);
    void updateUser(CinemaUser cinemaUser);
    void deleteUser(CinemaUser cinemaUser);
}
