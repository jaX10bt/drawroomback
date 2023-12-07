package com.example.drawroomback.business.profile;

import com.example.drawroomback.business.profile.dto.ProfileImageInfo;
import com.example.drawroomback.business.profile.dto.info.ProfileInfo;
import com.example.drawroomback.domain.image.Image;
import com.example.drawroomback.domain.image.ImageService;
import com.example.drawroomback.domain.profile.Profile;
import com.example.drawroomback.domain.profile.ProfileMapper;
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

    @Resource
    private ProfileMapper profileMapper;


    @Transactional
    public void editProfileImages(Integer userId, ProfileImageInfo profileImageInfo) {
        Profile profile = profileService.getProfileBy(userId);
        handleImagesUpdate(profileImageInfo, profile);
        handleNewImages(profileImageInfo, profile);
    }

    private void handleImagesUpdate(ProfileImageInfo profileImageInfo, Profile profile) {
        handleAvatarUpdate(profileImageInfo, profile);
        handleCoverUpdate(profileImageInfo, profile);
        profileService.saveProfile(profile);
    }

    private void handleAvatarUpdate(ProfileImageInfo profileImageInfo, Profile profile) {
        if (hasAvatar(profile)) {
            byte[] avatarAsBytes = ImageConverter.stringToByteArray(profileImageInfo.getAvatarData());
            Image avatar = profile.getAvatar();
            avatar.setData(avatarAsBytes);
            imageService.saveImage(avatar);
            profile.setAvatar(avatar);
        }
    }

    private void handleCoverUpdate(ProfileImageInfo profileImageInfo, Profile profile) {
        if (hasCover(profile)) {
            byte[] coverAsBytes = ImageConverter.stringToByteArray(profileImageInfo.getCoverData());
            Image cover = profile.getCover();
            cover.setData(coverAsBytes);
            imageService.saveImage(cover);
            profile.setCover(cover);
        }
    }

    private static boolean hasAvatar(Profile profile) {
        return profile.getAvatar() != null;
    }

    private static boolean hasCover(Profile profile) {
        return profile.getCover() != null;
    }

    private void handleNewImages(ProfileImageInfo profileImageInfo, Profile profile) {
        handleNewAvatar(profileImageInfo, profile);
        handleNewCover(profileImageInfo, profile);
    }

    private void handleNewAvatar(ProfileImageInfo profileImageInfo, Profile profile) {
        if (newAvatarIsRequired(profileImageInfo, profile)) {
            Image avatar = ImageConverter.stringToImage(profileImageInfo.getAvatarData());
            imageService.saveImage(avatar);
        }
    }

    private void handleNewCover(ProfileImageInfo profileImageInfo, Profile profile) {
        if (newCoverIsRequired(profileImageInfo, profile)) {
            Image cover = ImageConverter.stringToImage(profileImageInfo.getCoverData());
            imageService.saveImage(cover);
        }
    }

    private static boolean newAvatarIsRequired(ProfileImageInfo profileImageInfo, Profile profile) {
        return !imageDataExists(profile.getAvatar()) && imageDataExists(profileImageInfo.getAvatarData());
    }

    private static boolean newCoverIsRequired(ProfileImageInfo profileImageInfo, Profile profile) {
        return !imageDataExists(profile.getCover()) && imageDataExists(profileImageInfo.getCoverData());
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

    public ProfileInfo getProfileInfo(Integer userId) {

        Profile profile = profileService.getProfileBy(userId);
        return profileMapper.toProfileInfo(profile);

    }
}
