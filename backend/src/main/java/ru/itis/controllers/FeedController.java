package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.UsersService;

import java.security.Principal;

@Controller
public class FeedController {

    @Autowired
    private UsersService usersService;

    @GetMapping("/feed")
    public ModelAndView getPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("feed");
        modelAndView.addObject("user", usersService.getByUsername(principal.getName()));
        return modelAndView;
    }
}
