package edu.school21.cinema.repositories;

import edu.school21.cinema.models.ChatMessage;
import edu.school21.cinema.models.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
@PropertySource("classpath:../application.properties")
public class ChatMessageRepositoryImpl implements ChatMessageRepository {
    @Value("${messagesCount}")
    private int messagesCount;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ChatMessage> getAll() {
        return entityManager.createQuery("from ChatMessage", ChatMessage.class).getResultList();
    }

    @Override
    public List<ChatMessage> getMessagesFromMovie(Movie movie) {
        List<ChatMessage> result = entityManager.createQuery("from ChatMessage where movie_id=" + movie.getId() + "order by id desc", ChatMessage.class)
                .setMaxResults(messagesCount)
                .getResultList();
        Collections.reverse(result);
        return result;
    }

    @Override
    public void addChatMessage(ChatMessage chatMessage) {
        entityManager.merge(chatMessage);
    }
}
