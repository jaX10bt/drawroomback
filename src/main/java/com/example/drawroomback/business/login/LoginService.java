package com.example.drawroomback.business.login;

import com.example.drawroomback.business.login.dto.LoginResponse;
import com.example.drawroomback.domain.user.User;
import com.example.drawroomback.domain.user.UserMapper;
import com.example.drawroomback.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }


}
