package com.example.drawroomback.domain.post;


import com.example.drawroomback.business.Status;
import com.example.drawroomback.business.posts.dto.PostInfoRequest;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service

public class PostService {

    @Resource
    private PostRepository postRepository;

    public Post getRandomPost() {
        return postRepository.getRandomPost();
    }

    public Page<Post> getPostsPage(Integer postId, Pageable pagination) {
        return postRepository.getActivePostsBy(postId, Status.ACTIVE, pagination);
    }

    public void saveNewPost(Post post) {
        postRepository.save(post);
    }

}