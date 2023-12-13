package com.example.drawroomback.domain.post;

import com.example.drawroomback.business.Status;
import com.example.drawroomback.business.posts.dto.PostInfo;
import com.example.drawroomback.business.posts.dto.PostInfoRequest;
import com.example.drawroomback.domain.image.Image;
import com.example.drawroomback.util.ImageConverter;
import com.example.drawroomback.util.InstantConverter;
import org.mapstruct.*;

import java.time.Instant;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
        imports = {Instant.class, Status.class})
public interface PostMapper {

    //     @Mapping(source = "", target = "userAvatarImageData")

    @Mapping(source = "id", target = "postId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "image", target = "postImageData", qualifiedByName = "imageToString")
    @Mapping(source = "timestamp", target = "timestamp", qualifiedByName = "instantToString")
    @Mapping(source = "likeCount", target = "likeCount")
    PostInfo toPostInfo(Post post);

    List<PostInfo> toPostInfos(List<Post> posts);

    @Named("imageToString")
    static String imageToString(Image image) {
        return ImageConverter.imageToString(image);
    }

    @Named("instantToString")
    static String instantToString(Instant instant) {
        return InstantConverter.instantToString(instant);
    }


    @Mapping(expression = "java(Status.ACTIVE)", target = "status")
    @Mapping(expression = "java(Instant.now())", target = "timestamp")
    @Mapping(constant = "0", target = "likeCount")
    Post toPost(PostInfoRequest postInfoRequest);
}