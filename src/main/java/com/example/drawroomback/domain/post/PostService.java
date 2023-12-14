package com.example.drawroomback.domain.post;


import com.example.drawroomback.business.Status;
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

    public Page<Post> getPostsPage(Pageable pagination) {
        return postRepository.getActivePostsBy(Status.ACTIVE, pagination);
    }

    public void savePost(Post post) {
        postRepository.save(post);
    }

    public Post deletePostBy(Integer postId) {
        return postRepository.getReferenceById(postId);
    }


    public Post getPostBy(Integer postId) {
        return postRepository.getReferenceById(postId);
    }
}