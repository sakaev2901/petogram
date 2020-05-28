package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/signIn")
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView("logine");
        return modelAndView;
    }
}
