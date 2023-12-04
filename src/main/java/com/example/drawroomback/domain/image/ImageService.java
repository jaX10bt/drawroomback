package com.example.drawroomback.domain.image;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
class ImageService {
    @Resource
    private ImageRepository imageRepository;

}
