package com.webb.fontaine.exception;

import com.webb.fontaine.persistence.model.api.ApiError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    /**
     *
     * @return the ApiError object
     */

//    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
//    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
//        ApiError apiError = new ApiError(HttpStatus.CONFLICT, ex.getMessage(), ex);
//        return buildResponseEntity(apiError);
//    }

//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<Object> handleInvalidQueryException() {
//        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
//        apiError.setMessage("Invalid Query, search query cannot be empty!");
//        return buildResponseEntity(apiError);
//    }

//    @ExceptionHandler(Exception.class)
//    protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
//        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
//        return buildResponseEntity(apiError);
//    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}