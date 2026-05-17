package dev.gabryel.ecommerce.exception;

import lombok.Getter;

@Getter
public class PurchaseException extends RuntimeException {
    private final int status;

    public PurchaseException(String message, int status) {
        super(message);
        this.status = status;
    }
}
