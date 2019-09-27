package com.mettalica.client.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ServiceResponse<T extends BaseResponse> implements Serializable {

    private static final long serialVersionUID = 1L;

    private T response;
    private ServiceException exception;
}
