package com.ganeshgc.mobile_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MobileNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private String fieldValue;

    public MobileNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with %s :: %s", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
