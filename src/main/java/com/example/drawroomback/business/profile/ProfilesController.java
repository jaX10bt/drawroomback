package com.example.drawroomback.business.profile;

import com.example.drawroomback.business.profile.dto.ProfileImageInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfilesController {

    @Resource
    private ProfilesService profilesService;

    @PatchMapping("/profile")
    public void editProfileImages(@RequestParam Integer userId, @RequestBody ProfileImageInfo profileImageInfo) {
        profilesService.editProfileImages(userId, profileImageInfo);
    }
}
