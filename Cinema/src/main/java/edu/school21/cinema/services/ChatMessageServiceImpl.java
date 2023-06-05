package edu.school21.cinema.services;

import edu.school21.cinema.models.ChatMessage;
import edu.school21.cinema.models.Movie;
import edu.school21.cinema.repositories.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    @Autowired
    public ChatMessageServiceImpl(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    @Override
    public List<ChatMessage> getAll() {
        return chatMessageRepository.getAll();
    }

    @Override
    public List<ChatMessage> getMessagesFromMovie(Movie movie) {
        return chatMessageRepository.getMessagesFromMovie(movie);
    }

    @Override
    public void addChatMessage(ChatMessage chatMessage) {
        chatMessageRepository.addChatMessage(chatMessage);
    }
}
