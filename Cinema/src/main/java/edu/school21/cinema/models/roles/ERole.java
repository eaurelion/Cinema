package edu.school21.cinema.models.roles;

import edu.school21.cinema.models.CinemaUser;
import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "erole", columnNames = {"name"})})
public class ERole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<CinemaUser> users;

    public ERole() {
    }

    public ERole(Long id) {
        this.id = id;
    }

    public ERole(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CinemaUser> getUsers() {
        return users;
    }

    public void setUsers(Set<CinemaUser> users) {
        this.users = users;
    }

    @Override
    public String getAuthority() {
        return getName();
    }
}
