package com.metallica.controller;

import com.metallica.exception.ServiceException;
import com.metallica.exception.TradeNotFoundException;
import com.metallica.exception.ValidationException;
import com.metallica.model.response.BaseResponse;
import com.metallica.model.response.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class BaseController {

    @ExceptionHandler(ValidationException.class)
    public ServiceResponse<?> handleServiceException(ValidationException exception, HttpServletResponse http){
        ServiceResponse<?> serviceResponse = new ServiceResponse();
        serviceResponse.setException(exception);
        http.setStatus(HttpStatus.BAD_REQUEST.value());
        return serviceResponse;
    }

    @ExceptionHandler(ServiceException.class)
    public ServiceResponse<?> handleServiceException(ServiceException exception){
        ServiceResponse<?> serviceResponse = new ServiceResponse();
        serviceResponse.setException(exception);
        return serviceResponse;
    }

    @ExceptionHandler(RuntimeException.class)
    public <T extends BaseResponse> ServiceResponse<T> handleRuntimeException(RuntimeException exception, HttpServletResponse http){
        ServiceResponse<T> response = new ServiceResponse<T>();
        ServiceException genericException = new ServiceException(exception.getMessage());
        response.setException(genericException);
        http.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return response;
    }

    @ExceptionHandler(TradeNotFoundException.class)
    public <T extends BaseResponse> ServiceResponse<T> handleTradeNotFoundException(TradeNotFoundException exception, HttpServletResponse http){
        ServiceResponse<T> serviceResponse = new ServiceResponse();
        serviceResponse.setException(exception);
        http.setStatus(HttpStatus.NOT_FOUND.value());
        return serviceResponse;
    }

}
