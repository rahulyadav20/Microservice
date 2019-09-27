package com.metallica.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String errCode;
    private String errMsg;

    public ServiceException(String errMsg) {
        super(errMsg);
        this.errMsg = errMsg;
    }

    public ServiceException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
