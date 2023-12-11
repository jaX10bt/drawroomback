package com.example.drawroomback.domain.post;


import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service

public class PostService {

    @Resource
    private PostRepository postRepository;

    public Post getRandomPost() {
        return postRepository.getRandomPost();

    }
}
