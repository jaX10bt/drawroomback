package com.example.drawroomback.business.posts;


import com.example.drawroomback.business.posts.dto.PostImage;
import com.example.drawroomback.business.posts.dto.PostInfo;
import com.example.drawroomback.business.posts.dto.PostInfoRequest;
import com.example.drawroomback.domain.image.Image;
import com.example.drawroomback.domain.image.ImageService;
import com.example.drawroomback.domain.post.Post;
import com.example.drawroomback.domain.post.PostMapper;
import com.example.drawroomback.domain.post.PostService;
import com.example.drawroomback.domain.profile.ProfileService;
import com.example.drawroomback.domain.user.User;
import com.example.drawroomback.domain.user.UserService;
import com.example.drawroomback.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    @Resource
    private PostService postService;

    @Resource
    private ProfileService profileService;
    @Resource
    private ImageService imageService;
    @Resource
    private UserService userService;

    @Resource
    private PostMapper postMapper;


    public PostImage getRandomPost() {
        Post post = postService.getRandomPost();
        return new PostImage(ImageConverter.imageToString(post.getImage()));
    }

    public void addNewPost(PostInfoRequest postInfoRequest) {
        Image image = createAndSavePostImage(postInfoRequest);
        createAndSavePost(postInfoRequest, image);
    }

    private void createAndSavePost(PostInfoRequest postInfoRequest, Image image) {
        Post post = createPost(postInfoRequest, image);
        postService.saveNewPost(post);
    }

    private Post createPost(PostInfoRequest postInfoRequest, Image image) {
        User user = userService.getUserBy(postInfoRequest.getUserId());
        Post post = postMapper.toPost(postInfoRequest);
        post.setUser(user);
        post.setImage(image);
        return post;
    }

    private Image createAndSavePostImage(PostInfoRequest postInfoRequest) {
        String postImageData = postInfoRequest.getPostImageData();
        Image image = ImageConverter.stringToImage(postImageData);
        imageService.saveImage(image);
        return image;
    }

    public PostInfoResponse getPosts(Integer postId, Pageable pageable) {
        Page<Post> postsPage = postService.getPostsPage(postId, pageable);
        return getPostInfoResponse(postsPage);
    }

    private PostInfoResponse getPostInfoResponse(Page<Post> postsPage) {
        List<PostInfo> postInfos = getPostInfos(postsPage.getContent());

        addUserAvatarImageData(postInfos);

        PostInfoResponse postInfoResponse = new PostInfoResponse();
        postInfoResponse.setTotalPages(postsPage.getTotalPages());
        postInfoResponse.setPosts(postInfos);
        return postInfoResponse;
    }

    private void addUserAvatarImageData(List<PostInfo> postInfos) {
        for (PostInfo postInfo : postInfos) {
            Image avatar = profileService.getProfileBy(postInfo.getUserId()).getAvatar();
            postInfo.setUserAvatarImageData(ImageConverter.imageToString(avatar));
        }
    }

    private List<PostInfo> getPostInfos(List<Post> posts) {
        List<PostInfo> postInfos = postMapper.toPostInfos(posts);
        return postInfos;
    }

}
