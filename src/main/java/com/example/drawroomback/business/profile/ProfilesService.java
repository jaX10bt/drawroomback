package com.example.drawroomback.business.profile;

import com.example.drawroomback.business.profile.dto.ProfileInfo;
import com.example.drawroomback.domain.image.Image;
import com.example.drawroomback.domain.image.ImageService;
import com.example.drawroomback.domain.profile.Profile;
import com.example.drawroomback.domain.profile.ProfileService;
import com.example.drawroomback.util.ImageConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class ProfilesService {
    @Resource
    private ProfileService profileService;
    @Resource
    private ImageService imageService;

    @Transactional
    public void editProfileImages(ProfileInfo profileInfo) {
        Profile profile = profileService.findProfileBy(profileInfo.getProfileId());
        handleImagesUpdate(profileInfo, profile);
        handleNewImages(profileInfo, profile);
    }

    private void handleImagesUpdate(ProfileInfo profileInfo, Profile profile) {
        handleAvatarUpdate(profileInfo, profile);
        handleCoverUpdate(profileInfo, profile);
    }

    private void handleAvatarUpdate(ProfileInfo profileInfo, Profile profile) {
        if (hasAvatar(profile)) {
            byte[] avatarAsBytes = ImageConverter.stringToByteArray(profileInfo.getAvatarData());
            Image avatar = profile.getAvatar();
            avatar.setData(avatarAsBytes);
            imageService.saveImage(avatar);
        }
    }

    private void handleCoverUpdate(ProfileInfo profileInfo, Profile profile) {
        if (hasCover(profile)) {
            byte[] coverAsBytes = ImageConverter.stringToByteArray(profileInfo.getCoverData());
            Image cover = profile.getCover();
            cover.setData(coverAsBytes);
            imageService.saveImage(cover);
        }
    }

    private static boolean hasAvatar(Profile profile) {
        return profile.getAvatar() != null;
    }

    private static boolean hasCover(Profile profile) {
        return profile.getCover() != null;
    }

    private void handleNewImages(ProfileInfo profileInfo, Profile profile) {
        handleNewAvatar(profileInfo, profile);
        handleNewCover(profileInfo, profile);
    }

    private void handleNewAvatar(ProfileInfo profileInfo, Profile profile) {
        if (newAvatarIsRequired(profileInfo, profile)) {
            Image avatar = ImageConverter.stringToImage(profileInfo.getAvatarData());
            imageService.saveImage(avatar);
        }
    }

    private void handleNewCover(ProfileInfo profileInfo, Profile profile) {
        if (newCoverIsRequired(profileInfo, profile)) {
            Image cover = ImageConverter.stringToImage(profileInfo.getCoverData());
            imageService.saveImage(cover);
        }
    }

    private static boolean newAvatarIsRequired(ProfileInfo profileInfo, Profile profile) {
        return !imageDataExists(profile.getAvatar()) && imageDataExists(profileInfo.getAvatarData());
    }

    private static boolean newCoverIsRequired(ProfileInfo profileInfo, Profile profile) {
        return !imageDataExists(profile.getCover()) && imageDataExists(profileInfo.getCoverData());
    }

    private static boolean imageDataExists(Image image) {
        if (image == null) {
            return false;
        }
        return image.getData() != null && image.getData().length > 0;
    }

    private static boolean imageDataExists(String imageData) {
        return imageData != null && !imageData.isEmpty();
    }

}
