package java_adventure;

//*******************************************************************************
// File Name: Door.java
// Author: Mac Orchard
//
// Purpose: The class to represent doors in the dungeon. It will store references
// to the rooms it is connected to and to whether or not it is locked. If it is 
// locked it will also have a key reference.
//*******************************************************************************
public class Door {

    private boolean isLocked;
    private Room nextRoom;

    // Door Contructors
    public Door() {
        nextRoom = null;
        isLocked = false;
    }

    public Door(Room _nextRoom, boolean _isLocked) {
        nextRoom = _nextRoom;
        isLocked = _isLocked;
    }

    // isLocked properties
    public boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean _isLocked) {
        isLocked = _isLocked;
    }

    // nextRoom properties
    public Room getNextRoom() {
        return nextRoom;
    }

    public void setNextRoom(Room _nextRoom) {
        nextRoom = _nextRoom;
    }
    
    public String toString(){
       String text = "Door goes to " + nextRoom + ", Locked: " + isLocked;
        return text;
    }
}