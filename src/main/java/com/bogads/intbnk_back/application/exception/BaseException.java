package com.bogads.intbnk_back.application.exception;

import org.springframework.http.HttpStatus;

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

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(HttpStatus httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
