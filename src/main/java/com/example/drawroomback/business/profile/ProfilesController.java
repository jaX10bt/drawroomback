package com.example.drawroomback.business.profile;

import com.example.drawroomback.business.profile.dto.ProfileInfo;
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
    public void editProfileImages(@RequestBody ProfileInfo profileInfo) {
        profilesService.editProfileImages(profileInfo);
    }
}
