package com.example.drawroomback.domain.post;

import com.example.drawroomback.business.posts.dto.PostInfo;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {
    @Mapping(source = "imageData", target = "image.data")
    @Mapping(source = "imageId", target = "image.id")
    @Mapping(source = "userUsername", target = "user.username")
    @Mapping(source = "userId", target = "user.id")
    @Mapping(source = "postId", target = "id")
    Post toEntity(PostInfo postInfo);

    @InheritInverseConfiguration(name = "toEntity")
    PostInfo toDto(Post post);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Post partialUpdate(PostInfo postInfo, @MappingTarget Post post);
}