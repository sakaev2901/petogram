package ru.itis.repositories;

import org.springframework.stereotype.Component;
import ru.itis.models.User;

@Component
public interface UsersRepository {

    void save(User model);
}
