package edu.school21.cinema.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class AuthHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = {CascadeType.PERSIST})
    private CinemaUser cinemaUser;
    private String type;
    private String time;
    private String address;

    public AuthHistory(CinemaUser cinemaUser, String type, String time, String address) {
        this.cinemaUser = cinemaUser;
        this.type = type;
        this.time = time;
        this.address = address;
    }

    @Override
    public String toString() {
        return "AuthHistory{" +
                "type='" + type + '\'' +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
