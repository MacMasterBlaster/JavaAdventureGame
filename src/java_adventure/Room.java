//*******************************************************************************
// File Name: Room.java
// Author: Mac Orchard
//
// Purpose: 
//*******************************************************************************
package java_adventure;

public class Room {

    private boolean nDoor, sDoor, wDoor, eDoor, hasEnemy;

    public Room(boolean hasNDoor, boolean hasSDoor, boolean hasWDoor, boolean hasEDoor, boolean _hasEnemy){
        nDoor = hasNDoor;
        sDoor = hasSDoor;
        wDoor = hasWDoor;
        eDoor = hasEDoor;
        hasEnemy = _hasEnemy;
    }

//north door properties
    public boolean getnDoor() {
        return nDoor;
    }
    public void setnDoor(boolean doesExist) {
        nDoor = doesExist;
    }
//south door properties
    public boolean getsDoor() {
        return sDoor;
    }
    public void setsDoor(boolean doesExist) {
        sDoor = doesExist;
    }
//west door properties
    public boolean getwDoor() {
        return wDoor;
    }
    public void setwDoor(boolean doesExist) {
        wDoor = doesExist;
    }
//east door properties
    public boolean geteDoor() {
        return eDoor;
    }
    public void seteDoor(boolean doesExist) {
        eDoor = doesExist;
    }

//TODO: toString() required. Should build room image.

}