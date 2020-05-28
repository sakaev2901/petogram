package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Post;
import ru.itis.models.User;
import ru.itis.repositories.PostsRepository;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.UsersService;

import java.security.Principal;
import java.util.List;

@Controller
@CrossOrigin
public class ProfileController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/profile/{username}")
    public ModelAndView getPage(@PathVariable("username") String username, Principal principal, Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        User user = usersService.getByUsername(username);
        modelAndView.addObject("user", user);
        modelAndView.addObject("currentUser", principal.getName());
        System.out.println(user.getId());
        return modelAndView;
    }


    @PostMapping("/follow")
    public ResponseEntity<String> follow(@RequestParam("username") String username, Authentication authentication) {
        usersService.setFollowerToUser(username);
        return new ResponseEntity<>("Ok", HttpStatus.OK);
    }


}
