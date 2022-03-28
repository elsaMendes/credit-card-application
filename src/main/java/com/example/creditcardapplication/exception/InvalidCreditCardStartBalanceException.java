package com.example.creditcardapplication.exception;

public class InvalidCreditCardStartBalanceException extends RuntimeException {
    public InvalidCreditCardStartBalanceException(String message, Throwable e) {
        super(message, e);
    }

    public InvalidCreditCardStartBalanceException(String message) {
        super(message);
    }
}
