package com.avalanche.hotel.Exceptions.DomainExceptions;

public class InvalidRoomNumberException extends RuntimeException {
    public InvalidRoomNumberException(String message) {
        super(message);
    }
}
