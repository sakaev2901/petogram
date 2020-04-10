package ru.itis.repositories;

import javafx.geometry.Pos;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.itis.models.Like;
import ru.itis.models.Post;
import ru.itis.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Component
public class PostsRepositoryJpaImpl implements PostsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public <S extends Post> S save(S s) {
        entityManager.persist(s);
        return s;
    }

    @Override
    public <S extends Post> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Post> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }


    public List<Post> findAll() {
        return entityManager.createQuery("select с from Post с").getResultList();
    }

    @Override
    public List<Post> findAllByUser(User user) {
        return entityManager.createQuery("select c from Post c where c.user = :user")
                .setParameter("user", user)
                .getResultList();
    }

    @Override
    @Transactional
    public void saveLike(Like like) {
        entityManager.persist(like);
    }

    @Override
    public Iterable<Post> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Post post) {

    }

    @Override
    public void deleteAll(Iterable<? extends Post> iterable) {

    }

    @Override
    public void deleteAll() {

    }

//    @Override
//    @Transactional
//    public void save(Post post) {
//        entityManager.persist(post);
//    }
}
