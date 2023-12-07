package com.example.drawroomback.business.users;

import com.example.drawroomback.business.users.dto.UserInfo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/user")
    public void addNewUser(@RequestParam String username, @RequestParam String password) {
        usersService.addNewUser(username, password);
    }

    @GetMapping("/users/active")
    public List<UserInfo> findAllActiveUsers() {
        return usersService.findAllActiveUsers();

    }

}
