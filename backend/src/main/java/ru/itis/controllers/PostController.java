package ru.itis.controllers;


import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.itis.models.Like;
import ru.itis.models.Post;
import ru.itis.models.User;
import ru.itis.repositories.PostsRepository;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.PicsService;
import ru.itis.services.PostsService;
import ru.itis.services.UsersService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Principal;

@Controller
public class PostController {

    @Autowired
    private PostsService postsService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private PicsService picsService;

    @GetMapping("/like/{postId}")
    @ResponseBody
    public void setLike(@PathVariable("postId") Long postId, Principal principal) {
       postsService.setLikeToPost(postId);
    }

    @SneakyThrows
    @GetMapping("/image/{img-name:.+}")
    public void getImage(@PathVariable("img-name") String imageName, HttpServletResponse response) {
        IOUtils.copy(picsService.getImageInputStream(imageName), response.getOutputStream());
        response.flushBuffer();
    }
}
