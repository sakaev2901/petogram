package ru.itis.controllers;

import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class PicsController {

    @RequestMapping(value = "/picUpload", method = RequestMethod.GET)
    public ModelAndView getPage() {
        ModelAndView modelAndView = new ModelAndView("picUpload");
        return modelAndView;
    }

    @SneakyThrows
    @RequestMapping(value = "/picUpload", method = RequestMethod.POST)
    public void savePhoto(@RequestParam("file")MultipartFile multipartFile) {
        Path path = Paths.get("C:\\Projects\\petogram\\backend\\src\\main\\webapp\\WEB-INF\\upload\\pic.jpg");
        multipartFile.transferTo(path);
        System.out.println("Success");
    }
}
