package com.metallica.exception;

public class TradeNotFoundException extends ServiceException {

    public TradeNotFoundException(String errMsg) {
        super(errMsg);
    }

    public TradeNotFoundException(String errCode, String errMsg) {
        super(errCode, errMsg);
    }
}
