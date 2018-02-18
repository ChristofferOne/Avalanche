package com.avalanche.hotel.primitives;

import com.avalanche.hotel.Constants;
import com.avalanche.hotel.Exceptions.DomainExceptions.InvalidFloorNumberException;
import com.avalanche.hotel.Exceptions.DomainExceptions.InvalidRoomException;
import com.avalanche.hotel.Exceptions.InvalidRegexMatchException;
import com.avalanche.hotel.Exceptions.DomainExceptions.InvalidRoomNumberException;

public class RoomNumber {
    private final String roomNumber;
    private final String floorNumber;

    public RoomNumber(String roomNumber) {
        if (!roomNumber.matches("[0-9]+")) {
            throw new InvalidRegexMatchException("Invalid characters");
        }

        String[] characters = roomNumber.split("(?<!^)");
        if (characters.length == Constants.ROOMS_NUMBER_LENGTH) {
            if (Integer.parseInt(characters[0]) > 0 && Integer.parseInt(characters[0]) < (Constants.FLOORS + 1)) {
                this.floorNumber = characters[0];
            } else {
                throw new InvalidFloorNumberException("Invalid floor number");
            }

            int intRoomNumber = Integer.parseInt(characters[1] + characters[2]);
            if (intRoomNumber > 0 && intRoomNumber < (Constants.ROOMS_PER_FLOOR + 1)) {
                this.roomNumber = characters[1] + characters[2];
            } else {
                throw new InvalidRoomException("Invalid room");
            }
        } else {
            throw new InvalidRoomNumberException("Invalid room number length");
        }
    }

    public String getRoomNumber() {
        return this.floorNumber + this.roomNumber;
    }

    public String getFloorNumber() {
        return this.floorNumber;
    }

    public String getFloorRoomNumber() {
        return this.roomNumber;
    }
}
