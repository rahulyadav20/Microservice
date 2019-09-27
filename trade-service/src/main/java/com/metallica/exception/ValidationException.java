package com.metallica.exception;

public class ValidationException extends ServiceException {

    public ValidationException(String errMsg) {
        super(errMsg);
    }

    public ValidationException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }
}
