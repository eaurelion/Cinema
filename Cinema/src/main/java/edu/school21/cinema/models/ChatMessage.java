package edu.school21.cinema.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private MessageType type;
    private String content;
    private String sender;
    @ManyToOne(cascade = {CascadeType.DETACH})
    @JsonIgnoreProperties({"dateOfRelease", "description", "restrictions", "posterUrl", "hasImage"})
    private Movie movie;
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public ChatMessage(MessageType type, String content, String sender, Movie movie) {
        this.type = type;
        this.content = content;
        this.sender = sender;
        this.movie = movie;
    }
}
