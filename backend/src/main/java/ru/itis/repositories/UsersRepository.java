package ru.itis.repositories;

import org.springframework.stereotype.Component;
import ru.itis.models.User;

import java.util.List;

@Component
public interface UsersRepository {

    void save(User model);
    User findByUsername(String username);
    void update(User user, User following);
    List<User> findAll();
}
