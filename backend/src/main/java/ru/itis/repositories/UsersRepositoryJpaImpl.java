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

    @Override
    public User findByUsername(String username) {
        User user = entityManager.createQuery("select c from users c where c.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
        return user;
    }


}
