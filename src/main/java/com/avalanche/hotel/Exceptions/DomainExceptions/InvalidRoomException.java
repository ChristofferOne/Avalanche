package com.avalanche.hotel.Exceptions.DomainExceptions;

public class InvalidRoomException extends RuntimeException {
    public InvalidRoomException(String message) {
        super(message);
    }
}
