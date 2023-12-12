package com.example.drawroomback.business.posts.dto;

import com.example.drawroomback.business.posts.dto.PostInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostInfoResponse {
    private Integer totalPages;
    private List<PostInfo> posts;
}
