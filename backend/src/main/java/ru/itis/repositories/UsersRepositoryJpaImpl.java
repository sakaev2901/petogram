package ru.itis.repositories;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
@Transactional
public class UsersRepositoryJpaImpl implements UsersRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(User model) {
        entityManager.persist(model);
    }

    @Override
    @Transactional
    public User findByUsername(String username) {
        User user = entityManager.createQuery("select c from User c where c.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
        return user;
    }

    @Override
    @Transactional
    public void update(User user, User following) {
        entityManager.detach(user);
        user.addFollowing(following);
        entityManager.merge(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
