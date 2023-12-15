package com.example.drawroomback.domain.profile;

import com.example.drawroomback.business.profile.dto.ProfileInfo;
import com.example.drawroomback.business.profile.dto.UserProfileInfo;
import com.example.drawroomback.domain.image.Image;
import com.example.drawroomback.util.ImageConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {


    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.id", target = "profileUserId")
    @Mapping(source = "avatar", target = "avatarData", qualifiedByName = "imageToString")
    @Mapping(source = "cover", target = "coverData", qualifiedByName = "imageToString")
    ProfileInfo toProfileInfo(Profile profile);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "id", target = "profileId")
    @Mapping(source = "avatar", target = "avatarData", qualifiedByName = "imageToString")
    @Mapping(source = "cover", target = "coverData", qualifiedByName = "imageToString")
    UserProfileInfo toUserProfileInfo(Profile profile);




    @Named("imageToString")
    static String imageToString(Image image) {
        return ImageConverter.imageToString(image);
    }


}