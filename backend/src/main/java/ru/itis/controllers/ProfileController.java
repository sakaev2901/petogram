package ru.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public ModelAndView getPage() {
        return new ModelAndView("profile");
    }

    @PostMapping("/profile")
    public void profile() {
        System.out.println(3);
    }
}
