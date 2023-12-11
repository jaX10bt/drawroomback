package com.example.drawroomback.business.posts;

import com.example.drawroomback.business.posts.dto.PostImage;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PostsController {
    @Resource
    private PostsService postsService;

    @GetMapping("/post/random")
    public PostImage getRandomPost() {
        return postsService.getRandomPost();
    }
}
