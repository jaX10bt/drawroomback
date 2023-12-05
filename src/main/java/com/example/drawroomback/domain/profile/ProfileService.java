package com.example.drawroomback.domain.profile;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ProfileService {

    @Resource
    private ProfileRepository profileRepository;

    public void saveProfile(Profile profile) {
        profileRepository.save(profile);
    }

    public Profile getProfileBy(Integer userId) {
        return profileRepository.getProfileBy(userId);
    }
}
