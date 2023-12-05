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
public class ProfileInfo implements Serializable {
    private Integer profileId;
    private Integer coverId;
    private String coverData;
    private Integer avatarId;
    private String avatarData;
}