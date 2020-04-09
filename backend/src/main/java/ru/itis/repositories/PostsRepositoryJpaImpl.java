package ru.itis.repositories;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.Post;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class PostsRepositoryJpaImpl implements PostsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Post post) {
        entityManager.persist(post);
    }
}
