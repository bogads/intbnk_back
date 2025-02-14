package com.bogads.intbnk_back.application.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class NotFoundException extends BaseException {
    public NotFoundException(String message, String code, String detail) {
        super(message, code, HttpStatus.NOT_FOUND, detail);
    }
}
