package com.example.drawroomback.business.users;

import com.example.drawroomback.business.Status;
import com.example.drawroomback.domain.role.RoleService;
import com.example.drawroomback.domain.user.User;
import com.example.drawroomback.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsersService {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Transactional
    public void addNewUser(String username, String password) {
        userService.validateUsernameIsAvailable(username);
        User user = createUser(username, password);
        userService.saveUser(user);
        // TODO: lisada profile koos useriga
    }

    private User createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setStatus(Status.ACTIVE);
        user.setRole(roleService.getRoleCustomer());
        return user;
    }
}
