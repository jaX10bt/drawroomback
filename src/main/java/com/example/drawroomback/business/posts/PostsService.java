package com.example.drawroomback.business.posts;


import com.example.drawroomback.business.posts.dto.PostImage;
import com.example.drawroomback.domain.image.Image;
import com.example.drawroomback.domain.post.Post;
import com.example.drawroomback.domain.post.PostService;
import com.example.drawroomback.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PostsService {

    @Resource
    private PostService postService;


    public PostImage getRandomPost() {
        Post post = postService.getRandomPost();
        return new PostImage(ImageConverter.imageToString(post.getImage()));
    }
}
