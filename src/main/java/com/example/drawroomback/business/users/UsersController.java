package com.example.drawroomback.business.users;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/user")
    public void addNewUser(@RequestParam String username, @RequestParam String password) {
        usersService.addNewUser(username, password);
    }

}
