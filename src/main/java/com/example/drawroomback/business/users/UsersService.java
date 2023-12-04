package com.example.drawroomback.business.users;

import com.example.drawroomback.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Resource
    private UserService userService;

    public void addNewUser(String username, String password) {
        userService.validateUsernameIsAvailable(username);
        // TODO now that username availability has been checked, proceed with new user creation process
    }
}
