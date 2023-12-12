package com.example.drawroomback.business.posts;

import com.example.drawroomback.business.posts.dto.PostImage;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PostsController {
    @Resource
    private PostsService postsService;

    @GetMapping("/post/random")
    @Operation(summary = "Kuvab HomeViews suvalise postituse")
    public PostImage getRandomPost() {
        return postsService.getRandomPost();
    }

    @GetMapping("/posts/time")
    @Operation(summary = "Kuvab postitusi lehtede kaupa.")
    public PostInfoResponse getPosts(@RequestParam Integer postId, @RequestParam Integer pageNumber, @RequestParam Integer postsPerPage) {
        Pageable pageable = PageRequest.of(pageNumber, postsPerPage);
        return postsService.getPosts(postId, pageable);
    }

    @PostMapping("/post")
    public void addNewPost() {
    }
}
