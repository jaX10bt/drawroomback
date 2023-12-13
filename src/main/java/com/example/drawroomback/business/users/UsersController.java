package com.example.drawroomback.business.users;

import com.example.drawroomback.business.users.dto.UserInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {

    @Resource
    private UsersService usersService;

    @PostMapping("/user")
    @Operation(summary = "Lisab uue kasutaja.")

    public void addNewUser(@RequestParam String username, @RequestParam String password) {
        usersService.addNewUser(username, password);
    }

    @GetMapping("/users/active")
    @Operation(
            summary = "Leiab süsteemist (andmebaasist user tabelist) kõik aktiivsed kasutajad.",
            description = "Tagastab info username'idega")
    public List<UserInfo> findAllActiveUsers() {
        return usersService.findAllActiveUsers();

    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam Integer userId) {
        usersService.deleteUser(userId);
    }
}
