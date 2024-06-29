package com.ganeshgc.mobile_project.exception;

import com.ganeshgc.mobile_project.Dto.ErrorDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    //this method is to handle the exception all related to mobilenotfoundexception
    @ExceptionHandler(MobileNotFoundException.class)
    public ResponseEntity<ErrorDetails> MobileNotFoundExceptionHandler(MobileNotFoundException mobileNotFoundException, WebRequest webRequest) {
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),mobileNotFoundException.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    //this method is to all kind of other exception like generic
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> genericExceptionHandler(Exception exception, WebRequest webRequest) {
        ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(),exception.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        Map<String,String> map=new LinkedHashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)-> {
            String fieldName=((FieldError)error).getField();
            String errorMessage=error.getDefaultMessage();
            map.put(fieldName,errorMessage);
        });

        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

}
