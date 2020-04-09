package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.RegistrationForm;
import ru.itis.repositories.UsersRepository;

@Controller
@RequestMapping("/signUp")
public class RegistrationController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping
    public ModelAndView getPage() {
        return new ModelAndView("signUp");
    }

    @PostMapping
    public String processRegistration(RegistrationForm registrationForm) {
        usersRepository.save(registrationForm.toUser(passwordEncoder));
        return "redirect:/login";
    }


}
