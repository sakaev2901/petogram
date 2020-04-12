package ru.itis.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.models.Post;
import ru.itis.models.User;
import ru.itis.repositories.PostsRepository;
import ru.itis.repositories.UsersRepository;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PicsServiceImpl implements PicsService {

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public void save(MultipartFile multipartFile) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String currentPicName = multipartFile.getOriginalFilename();
        System.out.println(currentPicName.split("\\.")[1]);
        String extensionPic = currentPicName.split("\\.")[1];
        String picName = user.getId() + "-" + RandomStringUtils.randomAlphanumeric(10) + "." + extensionPic;
        Path path = Paths.get("C:\\Projects\\petogram\\backend\\src\\main\\webapp\\img\\" + picName);
        Path archetypePath = Paths.get("C:\\Projects\\petogram\\backend\\target\\backend-1.0-SNAPSHOT\\img\\" + picName);
        try {
            multipartFile.transferTo(path);
            multipartFile.transferTo(archetypePath);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        Post post = Post.builder()
                .picName(picName)
                .user(user)
                .build();
        System.out.println(user.getRole());
        postsRepository.save(post);
    }

    @Override
    public InputStream getImageInputStream(String imageName) {
        try {
            return new FileInputStream(new File("C:\\Projects\\petogram\\backend\\src\\main\\webapp\\img\\" + imageName));
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException(e);
        }

    }
}
