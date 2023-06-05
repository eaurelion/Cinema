package edu.school21.cinema.repositories;

import edu.school21.cinema.models.ChatMessage;
import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatMessageRepository {
    List<ChatMessage> getAll();
    List<ChatMessage> getMessagesFromMovie(Movie movie);
    void addChatMessage(ChatMessage chatMessage);
}
