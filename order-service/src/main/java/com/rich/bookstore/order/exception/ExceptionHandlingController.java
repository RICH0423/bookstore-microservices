package com.rich.bookstore.order.exception;

import com.rich.bookstore.order.controller.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CommonResponse> entityNotFound(EntityNotFoundException ex) {
        CommonResponse response = new CommonResponse();
        response.setCode(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage() + ", itemId: " + ex.getItemId());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InventoryInsufficientException.class)
    public ResponseEntity<CommonResponse> inventoryInsufficient(InventoryInsufficientException ex) {
        CommonResponse response = new CommonResponse();
        response.setCode(HttpStatus.NOT_ACCEPTABLE.value());
        response.setMessage(ex.getMessage() + ", itemId: " + ex.getItemId() + ", current quantity: " +
                ex.getCurrentQuantity() + ", request quantity: " + ex.getRequestQuantity());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
