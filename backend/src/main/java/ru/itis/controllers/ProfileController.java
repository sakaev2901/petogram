package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.Post;
import ru.itis.repositories.PostsRepository;
import ru.itis.repositories.UsersRepository;

import java.security.Principal;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/profile")
    public ModelAndView getPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("profile");
        List<Post> posts = usersRepository.findByUsername(principal.getName()).getPosts();
        modelAndView.addObject("posts", posts);
        return modelAndView;
    }

    @PostMapping("/profile")
    public void profile() {
        System.out.println(3);
    }
}
