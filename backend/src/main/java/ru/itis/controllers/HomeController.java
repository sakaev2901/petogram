package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @PostMapping("/")
    public void home() {
        System.out.println(6);
    }

    @GetMapping("/")
    public ModelAndView getPage() {
        return new ModelAndView("home");
    }
}
