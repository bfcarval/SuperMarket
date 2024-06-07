package com.supermarket.api.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(final Exception exception, final String message) {
        super(message, exception);
    }

    public ProductNotFoundException(final String message) {
        super(message);
    }
}
