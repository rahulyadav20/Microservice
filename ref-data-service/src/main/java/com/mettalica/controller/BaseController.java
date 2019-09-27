package com.mettalica.controller;

import com.mettalica.exception.ServiceException;
import com.mettalica.model.response.BaseResponse;
import com.mettalica.model.response.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

@RestControllerAdvice
public class BaseController {

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
}
