package com.example.drawroomback.domain.profile;

import com.example.drawroomback.business.profile.dto.ProfileInfo;
import org.mapstruct.*;

//@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
//public interface ProfileMapper {
//    @Mapping(source = "avatarData", target = "avatar.data")
//    @Mapping(source = "avatarId", target = "avatar.id")
//    @Mapping(source = "coverData", target = "cover.data")
//    @Mapping(source = "coverId", target = "cover.id")
//    @Mapping(source = "profileId", target = "id")
//    Profile toEntity(ProfileInfo profileInfo);
//
//    @InheritInverseConfiguration(name = "toEntity")
//    ProfileInfo toDto(Profile profile);
//
//    @InheritConfiguration(name = "toEntity")
//    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
//    Profile partialUpdate(ProfileInfo profileInfo, @MappingTarget Profile profile);
//}