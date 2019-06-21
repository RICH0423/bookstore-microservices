package com.rich.bookstore.order.exception;

import lombok.Getter;

@Getter
public class InventoryInsufficientException extends RuntimeException {

    private String itemId;
    private long currentQuantity;
    private long requestQuantity;

    public InventoryInsufficientException(String message, String itemId, long currentQuantity, long requestQuantity) {
        super(message);
        this.itemId = itemId;
        this.currentQuantity = currentQuantity;
        this.requestQuantity = requestQuantity;
    }
}
