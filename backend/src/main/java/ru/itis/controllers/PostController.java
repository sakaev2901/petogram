package ru.itis.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.Like;
import ru.itis.models.Post;
import ru.itis.models.User;
import ru.itis.repositories.PostsRepository;
import ru.itis.repositories.UsersRepository;

import java.security.Principal;

@Controller
public class PostController {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private UsersRepository usersRepository;

    @GetMapping("/like/{postId}")
    @ResponseBody
    public void setLike(@PathVariable("postId") Long postId, Principal principal) {
        User user = usersRepository.findByUsername(principal.getName());
        Post post = Post.builder()
                .id(postId)
                .user(user)
                .build();
        Like like = Like.builder()
                .post(post)
                .user(user)
                .build();
        postsRepository.saveLike(like);
    }
}
