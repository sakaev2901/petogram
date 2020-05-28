package ru.itis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationForm {
    private String name;
    private String username;
    @Email(message = "Your email is incorrect")
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
