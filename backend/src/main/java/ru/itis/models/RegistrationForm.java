package ru.itis.models;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.repositories.UsersRepository;
import sun.java2d.pipe.SpanShapeRenderer;

@Data
public class RegistrationForm {
    private String name;
    private String username;
    private String mail;
    private String password;

    public User toUser(PasswordEncoder passwordEncoder) {
        return User.builder()
                .name(this.name)
                .mail(this.mail)
                .username(this.username)
                .password(encodePassword(passwordEncoder))
                .build();
    }

    private String encodePassword(PasswordEncoder passwordEncoder) {
        return passwordEncoder.encode(this.password);
    }
}
