package ru.itis.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import ru.itis.models.User;

public interface PicsService {
    public void save(MultipartFile multipartFile, User user);
}
