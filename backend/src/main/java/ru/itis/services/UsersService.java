package ru.itis.services;

import ru.itis.models.User;

public interface UsersService {
    public User getByUsername(String username);
    public void updateUser(User user);

    void setFollowerToUser(String username);
}
