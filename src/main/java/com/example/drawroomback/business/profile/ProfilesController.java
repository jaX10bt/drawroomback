package com.example.drawroomback.business.profile;

import com.example.drawroomback.business.profile.dto.ProfileInfo;
import com.example.drawroomback.business.profile.dto.UserProfileInfo;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfilesController {

    @Resource
    private ProfilesService profilesService;

    @GetMapping("/profile")
    @Operation(summary = "Tagastab userId abil kasutaja avatar ja cover image.")
    public ProfileInfo getProfileInfo(@RequestParam Integer userId) {
        return profilesService.getProfileInfo(userId);

    }

    @GetMapping("/profile/other")
    @Operation(summary = "Tagastab userId abil kasutaja avatari, cover image ja username.")
    public UserProfileInfo getUserProfileInfo(@RequestParam Integer userId) {
        return profilesService.getUserProfileInfo(userId);
    }

    @PatchMapping("/profile")
    @Operation(summary = "Uuendab userId abil kasutaja avatar ja cover pildi.",
            description = """
                    Kui andmebaasis pole pilti ja sõnumi kehas on pilt, siis lisatakse andmebaasi uus pilt.
                    Kui andmebaasis on pilt aga sõnumi kehas olev pilt on erinev, siis uuendatakse olemasolevat pilti"""
    )
    public void editProfileImages(@RequestBody ProfileInfo profileInfo) {
        profilesService.editProfileImages(profileInfo);
    }
}
