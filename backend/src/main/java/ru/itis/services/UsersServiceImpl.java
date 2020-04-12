package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public User getByUsername(String username) {
        return usersRepository.findByUsername(username);
    }

    @Override
    public void updateUser(User user) {
        usersRepository.update(user, null);
    }

    @Override
    public void setFollowerToUser(String username) {
        User following = usersRepository.findByUsername(username);
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(username.equals("andrey")) {
            System.out.println(4);
        }
//        user.addFollowing(following);
//        following.addFollower(user);
        usersRepository.update(user, following);
//        usersRepository.update(following);
    }
}
