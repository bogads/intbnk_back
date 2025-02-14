package com.bogads.intbnk_back.application.exception;

import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends BaseException {
    public NotFoundException(String message, String code, String detail) {
        super(message, code, HttpStatus.NOT_FOUND, detail);
    }
}
