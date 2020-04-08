package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

@Controller
public class SignInController {

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView("signIn");
        return modelAndView;
    }


    @RequestMapping(value = "signIn", method = RequestMethod.POST)
    public void signIn(@RequestParam("name") String name, @RequestParam("mail") String mail) {
        usersRepository.save(new User().builder()
                .name(name)
                .mail(mail)
                .build());
    }
}
