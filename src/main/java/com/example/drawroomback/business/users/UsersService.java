package com.example.drawroomback.business.users;

import com.example.drawroomback.business.Status;
import com.example.drawroomback.business.users.dto.UserInfo;
import com.example.drawroomback.domain.profile.Profile;
import com.example.drawroomback.domain.profile.ProfileService;
import com.example.drawroomback.domain.role.RoleService;
import com.example.drawroomback.domain.user.User;
import com.example.drawroomback.domain.user.UserMapper;
import com.example.drawroomback.domain.user.UserService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Resource
    private UserService userService;

    @Resource
    private ProfileService profileService;

    @Resource
    private RoleService roleService;

    @Resource
    private UserMapper userMapper;

    @Transactional
    public void addNewUser(String username, String password) {
        userService.validateUsernameIsAvailable(username);
        User user = createUser(username, password);
        userService.saveUser(user);
        Profile profile = createProfile(user);
        profileService.saveProfile(profile);
    }

    private Profile createProfile(User user) {
        Profile profile = new Profile();
        profile.setUser(user);
        return profile;
    }

    private User createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setStatus(Status.ACTIVE);
        user.setRole(roleService.getRoleCustomer());
        return user;
    }

    public List<UserInfo> findAllActiveUsers() {
        List<User> users = userService.findAllActiveUsers();
        return userMapper.toUserInfos(users);
    }

    public void deleteUser(Integer userId) {
        User user = userService.deleteUserBy(userId);
        user.setStatus(Status.DELETED);
        userService.saveUser(user);
    }
}
