package com.example.drawroomback.business.posts.dto;

import com.example.drawroomback.domain.post.Post;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Post}
 */
@Value
public class PostInfo implements Serializable {
    Integer postId;
    Integer userId;
    String userUsername;
    Integer imageId;
    byte[] imageData;
    @NotNull
    Instant timestamp;
    @NotNull
    String status;
    @NotNull
    Integer likeCount;
}