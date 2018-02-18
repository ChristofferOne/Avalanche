package com.avalanche.hotel.primitives;

import com.avalanche.hotel.Exceptions.DomainExceptions.InvalidFloorNumberException;
import com.avalanche.hotel.Exceptions.DomainExceptions.InvalidRoomException;
import com.avalanche.hotel.Exceptions.DomainExceptions.InvalidRoomNumberException;
import com.avalanche.hotel.Exceptions.InvalidRegexMatchException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomNumberTest {
    @Test(expected = InvalidRegexMatchException.class)
    public void testIllegalCharacters() {
        new RoomNumber("Test");
    }

    @Test(expected = InvalidFloorNumberException.class)
    public void testInvalidFloorNumber() {
        new RoomNumber("902");
    }

    @Test(expected = InvalidRoomNumberException.class)
    public void testInvalidLength() {
        new RoomNumber("1002");
    }

    @Test(expected = InvalidRoomException.class)
    public void testInvalidRoom() {
        new RoomNumber("112");
    }

    @Test
    public void testGetters() {
        RoomNumber roomNumber = new RoomNumber("204");
        String floorNumber = roomNumber.getFloorNumber();
        String floorRoomNumber = roomNumber.getFloorRoomNumber();
        String RoomNumber = roomNumber.getRoomNumber();

        assertEquals("2", floorNumber);

        assertEquals("04", floorRoomNumber);

        assertEquals("204", RoomNumber);
    }
}
