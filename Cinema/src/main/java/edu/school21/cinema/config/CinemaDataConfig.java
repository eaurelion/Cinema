package edu.school21.cinema.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
@PropertySource("classpath:../application.properties")
public class CinemaDataConfig {
    @Value("${uploadPath}")
    private String path;

    @Value("${avatarPath}")
    private String avatarPath;

    @Value("${messagesCount}")
    private int messagesCount;

    @Bean()
    public EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("CinemaUnit");
    }

    @Bean()
    public EntityManager entityManager() {
        return entityManagerFactory().createEntityManager();
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public String uploadPath() {
        return path;
    }

    @Bean
    public String avatarPath() {
        return avatarPath;
    }

    @Bean
    public int messagesCount() {
        return messagesCount;
    }
}
