package com.example.drawroomback.infrastructure.validation;

import lombok.Getter;

@Getter
public enum Error {
    INCORRECT_CREDENTIALS("Wrong username or password", 111);

    private final String message;
    private final int errorCode;

    Error(String message, int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
