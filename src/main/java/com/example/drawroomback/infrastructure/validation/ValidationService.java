package com.example.drawroomback.infrastructure.validation;

import com.example.drawroomback.domain.user.User;
import com.example.drawroomback.infrastructure.exception.BusinessException;

import java.util.Optional;

import static com.example.drawroomback.infrastructure.validation.Error.*;

public class ValidationService {

    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void validateUsernameIsAvailable(boolean usernameExists) {
        if (usernameExists) {
            throw new BusinessException(USERNAME_UNAVAILABLE.getMessage(), USERNAME_UNAVAILABLE.getErrorCode());
        }
    }
}
