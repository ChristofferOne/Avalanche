package com.avalanche.hotel.Exceptions;

public class InvalidRegexMatchException extends RuntimeException {
    public InvalidRegexMatchException(String message) {
        super(message);
    }
}
