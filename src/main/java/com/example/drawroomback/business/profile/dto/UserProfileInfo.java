package com.example.drawroomback.business.profile.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.example.drawroomback.domain.profile.Profile}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileInfo implements Serializable {
    private Integer profileId;
    private Integer userId;
    private String username;
    private String coverData;
    private String avatarData;
}