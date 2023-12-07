package com.example.drawroomback.domain.user;

import com.example.drawroomback.business.Status;
import com.example.drawroomback.infrastructure.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    public User findActiveUserBy(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password, Status.ACTIVE);
        User user = ValidationService.getValidUser(optionalUser);
        return user;
    }

    public void validateUsernameIsAvailable(String username) {
        boolean usernameExists = userRepository.userExistsBy(username);
        ValidationService.validateUsernameIsAvailable(usernameExists);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public List<User> findAllActiveUsers() {
        return userRepository.findUsersBy(Status.ACTIVE);
    }
}
