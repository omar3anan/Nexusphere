package com.RestAPIs.restfulwebservice.HandleError;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
@ControllerAdvice //handle all controller
public class ResponseEntityExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException (Exception exc, WebRequest request){

        ErrorResponse error =new ErrorResponse();
   
        error.setStatus(HttpStatus.NOT_FOUND.value()); //HttpStatus
        error.setMessage(exc.getMessage());  //message ==>  StudentNotFoundException
        error.setTimeStamp(System.currentTimeMillis()); //System.
        error.setDescription(request.getDescription(false));

        return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);  //(error Object , HttpStatus)
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllException(Exception exc,WebRequest request){
        ErrorResponse error =new ErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());  //400
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setDescription(request.getDescription(false));

        return new ResponseEntity<ErrorResponse>(error,HttpStatus.BAD_REQUEST);
    }

}



