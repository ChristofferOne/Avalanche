package com.avalanche.hotel.Exceptions.DomainExceptions;

public class InvalidFloorNumberException extends RuntimeException {
    public InvalidFloorNumberException(String message) {
        super(message);
    }
}
