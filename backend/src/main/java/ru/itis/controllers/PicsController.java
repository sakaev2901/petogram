package ru.itis.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.PicsService;
import ru.itis.services.UsersService;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;

@Controller
public class PicsController {

    @Autowired
    private UsersService usersService;
    @Autowired
    private PicsService picsService;

    @RequestMapping(value = "/picUpload", method = RequestMethod.GET)
    public ModelAndView getPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("picUpload");
        modelAndView.addObject("username", principal.getName());
        return modelAndView;
    }

    @SneakyThrows
    @RequestMapping(value = "/picUpload", method = RequestMethod.POST)
    public void savePhoto(@RequestParam("file")MultipartFile multipartFile, Principal principal) {
        picsService.save(multipartFile);
    }
}
