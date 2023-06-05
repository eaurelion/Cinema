package edu.school21.cinema.services;

import edu.school21.cinema.models.ChatMessage;
import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatMessageService {
    List<ChatMessage> getAll();
    List<ChatMessage> getMessagesFromMovie(Movie movie);
    void addChatMessage(ChatMessage chatMessage);
}
