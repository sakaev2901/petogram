package ru.itis.repositories;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class UsersRepositoryJpaImpl implements UsersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(User model) {
        entityManager.persist(model);
    }
}
