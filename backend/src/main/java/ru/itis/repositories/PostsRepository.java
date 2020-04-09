package ru.itis.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.itis.models.Post;
import ru.itis.models.User;

import java.util.List;

public interface PostsRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();
    List<Post> findAllByUser(User user);
}
