package edu.school21.cinema.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Date dateOfRelease;
    private int restrictions;
    private String description;
    public String posterUrl;
    private boolean hasImage;
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<CinemaSession> sessions;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<ChatMessage> messages;

    public Movie() {
        this.hasImage = false;
    }
    public Movie(String title, Date dateOfRelease, int restrictions, String description) {
        this.title = title;
        this.dateOfRelease = dateOfRelease;
        this.restrictions = restrictions;
        this.description = description;
        this.sessions = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    public String formatDate() {
        return dateOfRelease.toString().split(" ")[0];
    }

    public void addChatMessage(String content, String sender) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setType(ChatMessage.MessageType.CHAT);
        chatMessage.setMovie(this);
        chatMessage.setContent(content);
        chatMessage.setSender(sender);
        messages.add(chatMessage);
    }
}
