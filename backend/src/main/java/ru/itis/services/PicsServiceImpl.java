package ru.itis.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.itis.models.Post;
import ru.itis.models.User;
import ru.itis.repositories.PostsRepository;
import ru.itis.repositories.UsersRepository;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class PicsServiceImpl implements PicsService {

    @Autowired
    private PostsRepository postsRepository;

    @Override
    public void save(MultipartFile multipartFile, User user) {
        String currentPicName = multipartFile.getOriginalFilename();
        System.out.println(currentPicName.split("\\.")[1]);
        String extensionPic = currentPicName.split("\\.")[1];
        String picName = user.getId() + "-" + RandomStringUtils.randomAlphanumeric(10) + "." + extensionPic;
        Path path = Paths.get("C:\\Projects\\petogram\\backend\\src\\main\\webapp\\WEB-INF\\upload\\" + picName);
        try {
            multipartFile.transferTo(path);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        Post post = Post.builder()
                .pic_name(picName)
                .user(user)
                .build();
        System.out.println(user.getRole());
        postsRepository.save(post);
    }
}
