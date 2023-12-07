package com.example.drawroomback.business.profile;

import com.example.drawroomback.business.profile.dto.ProfileImageInfo;
import com.example.drawroomback.business.profile.dto.info.ProfileInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfilesController {

    @Resource
    private ProfilesService profilesService;

    @GetMapping("/profile")
    public ProfileInfo getProfileInfo(@RequestParam Integer userId) {
        return profilesService.getProfileInfo(userId);
    }

    @PatchMapping("/profile")
    public void editProfileImages(@RequestParam Integer userId, @RequestBody ProfileImageInfo profileImageInfo) {
        profilesService.editProfileImages(userId, profileImageInfo);
    }
}
