package com.example.drawroomback.business.posts;

import com.example.drawroomback.business.posts.dto.PostImage;
import com.example.drawroomback.business.posts.dto.PostInfoRequest;
import com.example.drawroomback.business.posts.dto.PostInfoResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController

public class PostsController {
    @Resource
    private PostsService postsService;

    @GetMapping("/post/random")
    @Operation(summary = "Kuvab HomeViews suvalise postituse")
    public PostImage getRandomPost() {
        return postsService.getRandomPost();
    }

    @GetMapping("/posts")
    @Operation(summary = "Kuvab postitusi lehtede kaupa.")
    public PostInfoResponse getPosts(@RequestParam Integer pageNumber, @RequestParam Integer postsPerPage) {
        Pageable pageable = PageRequest.of(pageNumber, postsPerPage);
        return postsService.getPosts(pageable);
    }

    @PostMapping("/post")
    public void addNewPost(@RequestBody PostInfoRequest postInfoRequest) {
        postsService.addNewPost(postInfoRequest);
    }
}
