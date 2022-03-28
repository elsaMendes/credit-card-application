package com.example.creditcardapplication.exception;

public class InvalidCreditCardNumberException extends RuntimeException {
    public InvalidCreditCardNumberException(String message, Throwable e) {
        super(message, e);
    }

    public InvalidCreditCardNumberException(String message) {
        super(message);
    }
}
