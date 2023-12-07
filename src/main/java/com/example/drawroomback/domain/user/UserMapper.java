package com.example.drawroomback.domain.user;

import com.example.drawroomback.business.login.dto.LoginResponse;
import com.example.drawroomback.business.users.dto.UserInfo;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);



    @Mapping(source = "id", target = "userId")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "status", target = "status")
    UserInfo toUserInfo(User user);


    List<UserInfo> toUserInfos(List<User> users);


}