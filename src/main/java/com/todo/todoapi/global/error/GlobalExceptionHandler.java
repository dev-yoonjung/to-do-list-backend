package com.todo.todoapi.global.error;

import com.todo.todoapi.global.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * javax.validation.Valid or @Validated binding error occurs
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponse> handleBindException(BindException exception) {
        log.error("handle bind exception", exception);
        List<String> errorMessages = new ArrayList<>();
        BindingResult bindingResult = exception.getBindingResult();
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                errorMessages.add(fieldError.getDefaultMessage());
            }
        }

        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, errorMessages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * If @RequestParam cannot be bound to Enum, it will occur
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException exception) {
        log.error("handle method argument type mismatch exception", exception);
        List<String> errorMessages = List.of(exception.getMessage());
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.BAD_REQUEST, errorMessages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    /**
     * Occurs when calling an unsupported HTTP method.
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
        log.error("handle http request method not supported exception", exception);
        List<String> errorMessages = List.of(exception.getMessage());
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.METHOD_NOT_ALLOWED, errorMessages);
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(errorResponse);
    }

    /**
     * Error running business logic
     */
    @ExceptionHandler(value = { BusinessException.class })
    protected ResponseEntity<ErrorResponse> handleConflict(BusinessException exception) {
        log.error("business exception", exception);
        List<String> errorMessages = List.of(exception.getMessage());
        HttpStatus httpStatus = HttpStatus.valueOf(exception.getStatus());
        ErrorResponse errorResponse = ErrorResponse.of(httpStatus, errorMessages);
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    /**
     * Occur other exceptions.
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception exception) {
        log.error("exception", exception);
        List<String> errorMessages = List.of(exception.getMessage());
        ErrorResponse errorResponse = ErrorResponse.of(HttpStatus.INTERNAL_SERVER_ERROR, errorMessages);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

}
