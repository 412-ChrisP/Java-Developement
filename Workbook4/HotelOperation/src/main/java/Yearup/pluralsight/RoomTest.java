package Yearup.pluralsight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest
{

    @Test
    public void checkIn_RoomInitialStatus_RoomIsOccupiedAndDirty()
    {
        // Arrange
        Room room = new Room(2, 100.0, false, false);
        // Act
        room.checkIn();
        // Assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void checkout_RoomIsOccupied_RoomIsNotOccupied()
    {
        // Arrange
        Room room = new Room(1, 50.0, false, false);
        room.checkIn();
        // Act
        room.checkout();
        // Assert
        assertFalse(room.isOccupied());
    }

    @Test
    public void checkIn_RoomIsOccupied_RoomRemainsOccupied()
    {
        // Arrange
        Room room = new Room(2, 100.0, false, false);
        room.checkIn();
        // Act
        room.checkIn();
        // Assert
        assertTrue(room.isOccupied());
    }

    @Test
    public void cleanRoom_RoomIsOccupied_RoomRemainsDirty()
    {
        // Arrange
        Room room = new Room(2, 100.0, true, true);
        // Act
        room.cleanRoom();
        // Assert
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    @Test
    public void cleanRoom_RoomIsNotOccupied_RoomIsCleaned()
    {
        // Arrange
        Room room = new Room(1, 50.0, false, true);
        room.cleanRoom();
        // Act
        room.cleanRoom();
        // Assert
        assertFalse(room.isDirty());
    }
}
