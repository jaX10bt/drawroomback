package com.example.drawroomback.business.profile.dto.info;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public class ProfileInfo {

    @NotNull
    private Integer profileId;

    private String avatarImageData;
    private String coverImageData;

}
