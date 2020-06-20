package ru.itis.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.services.UsersService;

import java.security.Principal;

@RestController
public class FeedRestController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/feed")
    public User getUser(Principal principal) {
        return usersService.getByUsername(principal.getName());
    }
}
