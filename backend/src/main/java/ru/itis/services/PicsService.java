package ru.itis.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import ru.itis.models.User;

import java.io.InputStream;

public interface PicsService {
    void save(MultipartFile multipartFile);
    InputStream getImageInputStream(String imageName);
}
