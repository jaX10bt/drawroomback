package com.example.drawroomback.business.posts.dto;

import com.example.drawroomback.domain.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInfo implements Serializable {
    private Integer userId;
    private String username;
    private String userAvatarImageData;
    private String postImageData;
    private String timestamp;
    private Integer likeCount;
}