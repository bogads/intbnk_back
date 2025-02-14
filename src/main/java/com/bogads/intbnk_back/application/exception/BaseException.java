package com.bogads.intbnk_back.application.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public abstract class BaseException extends RuntimeException {
    private String message;
    private String code;
    private HttpStatus httpStatusCode;
    private String detail;

    public BaseException(String message, String code, HttpStatus httpStatusCode, String detail) {
        super("message: " + message + "detail: " + detail);
        this.message = message;
        this.code = code;
        this.httpStatusCode = httpStatusCode;
        this.detail = detail;
    }
}
