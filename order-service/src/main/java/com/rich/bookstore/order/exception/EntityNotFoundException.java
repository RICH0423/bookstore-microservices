package com.rich.bookstore.order.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {

    private String itemId;

    public EntityNotFoundException(String message, String itemId) {
        super(message);
        this.itemId = itemId;
    }
}
