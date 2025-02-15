package com.bogads.intbnk_back.application.exception;


import static com.bogads.intbnk_back.application.utils.constants.ErrorCode.COMPANY_NOT_FOUND_ERROR_CODE;

public abstract class CompanyNotFoundException extends NotFoundException {
    public CompanyNotFoundException(String detail) {
        super("The company was not found", COMPANY_NOT_FOUND_ERROR_CODE, detail);
    }
}
