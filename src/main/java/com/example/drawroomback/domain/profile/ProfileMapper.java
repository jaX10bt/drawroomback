package com.example.drawroomback.domain.profile;

import com.example.drawroomback.business.profile.dto.info.ProfileInfo;
import com.example.drawroomback.domain.image.Image;
import com.example.drawroomback.util.ImageConverter;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfileMapper {

    @Mapping(source = "id" , target = "profileId")
    @Mapping(source = "avatar" , target = "avatarImageData", qualifiedByName = "imageToString")
    @Mapping(source = "cover" , target = "coverImageData", qualifiedByName = "imageToString")
    ProfileInfo toProfileInfo(Profile profile);

    @Named("imageToString")
    static String imageToString(Image image) {
        return ImageConverter.imageToString(image);

    }

}