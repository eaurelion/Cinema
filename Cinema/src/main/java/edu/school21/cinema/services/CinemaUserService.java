package edu.school21.cinema.services;

import edu.school21.cinema.models.CinemaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public interface CinemaUserService extends UserDetailsService {
    List<CinemaUser> getAll();
    CinemaUser getCinemaUserById(Long id);
    CinemaUser getCinemaUserByUserName(String username);
    boolean createCinemaUser(CinemaUser cinemaUser);
    void updateCinemaUser(CinemaUser cinemaUser);
    void deleteCinemaUser(CinemaUser cinemaUser);
}
