package ru.itis.config;

import javafx.geometry.Pos;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import ru.itis.models.Like;
import ru.itis.models.Post;
import ru.itis.models.User;
import ru.itis.repositories.PostsRepository;
import ru.itis.repositories.UsersRepository;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationContextConfig.class);
        PostsRepository postsRepository = applicationContext.getBean(PostsRepository.class);
        UsersRepository usersRepository = applicationContext.getBean(UsersRepository.class);
        System.out.println(postsRepository);
        User user = User.builder()
                .id(2l)
                .build();
        Post post = Post.builder()
                .id(10l)
                .user(user)
//                .picName("name")
                .build();
//        postsRepository.save(post);
        List<Post> posts = usersRepository.findByUsername("user").getPosts();
        Like like = Like.builder()
                .post(post)
                .user(user)
                .build();
        postsRepository.saveLike(like);
        System.out.println(4);
    }
}
