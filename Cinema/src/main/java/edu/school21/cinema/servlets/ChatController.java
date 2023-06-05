package edu.school21.cinema.servlets;

import edu.school21.cinema.models.ChatMessage;
import edu.school21.cinema.services.ChatMessageService;
import edu.school21.cinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@Controller
public class ChatController {
    private final ChatMessageService chatMessageService;

    private final MovieService movieService;

    @Autowired
    public ChatController(ChatMessageService chatMessageService, MovieService movieService) {
        this.chatMessageService = chatMessageService;
        this.movieService = movieService;
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        chatMessageService.addChatMessage(chatMessage);
        return chatMessage;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        Objects.requireNonNull(headerAccessor.getSessionAttributes()).put("username", chatMessage.getSender());
        return chatMessage;
    }

    @GetMapping("/chat/messages")
    @ResponseBody
    public List<ChatMessage> getMessages() {
        return chatMessageService.getAll();
    }

    @PostMapping("/chat/messages/add")
    @ResponseBody
    public List<ChatMessage> addMessages(@RequestBody ChatMessage chatMessage) {
        chatMessageService.addChatMessage(chatMessage);
        return chatMessageService.getAll();
    }

    @GetMapping("/chat/messages/{id}")
    @ResponseBody
    public List<ChatMessage> getMessagesFromMovie(@PathVariable ("id") String id) {
        return chatMessageService.getMessagesFromMovie(movieService.getMovieById(Long.parseLong(id)));
    }
}
