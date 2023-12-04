package com.example.drawroomback.infrastructure.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Wrong username or password", 111),
    USERNAME_UNAVAILABLE("Username unavailable", 333);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
