//*******************************************************************************
// File Name: Room.java
// Author: Mac Orchard
//
// Purpose: 
//*******************************************************************************
package java_adventure;

public class Room {

    private Room[] exits = new Room[4];
    private CharacterController monster;
    private boolean hasMonster, hasChest;
    private RoomImage roomImage;
    private String name;
    
    // Room Contructor
    public Room() {
        exits[0] = null; // north
        exits[1] = null; // east
        exits[2] = null; // south
        exits[3] = null; // west
        monster = null;
        hasMonster = false;
        hasChest = false;
        roomImage = null;
        name = "";
    }

    public void setExits(Room nRoom, Room eRoom, Room sRoom, Room wRoom) {
        exits[0] = nRoom; // north
        exits[1] = eRoom; // east
        exits[2] = sRoom; // south
        exits[3] = wRoom; // west
    }

    // north door properties
    public Room getnDoor() {
        return exits[0];
    }

    public void setnDoor(Room nextRoom) {
        exits[0] = nextRoom;
    }

    // south door properties
    public Room getsDoor() {
        return exits[2];
    }

    public void setsDoor(Room nextRoom) {
        exits[2] = nextRoom;
    }

    // east door properties
    public Room geteDoor() {
        return exits[1];
    }

    public void seteDoor(Room nextRoom) {
        exits[1] = nextRoom;
    }

    // west door properties
    public Room getwDoor() {
        return exits[3];
    }

    public void setwDoor(Room nextRoom) {
        exits[3] = nextRoom;
    }

    // monster Properties
    public CharacterController getMonster() {
        return monster;
    }

    public void setMonster(CharacterController _monster) {
        monster = _monster;
    }

    public boolean getHasMonster() {
        return hasMonster;
    } 

    public void setHasMonster(boolean _hasMonster) {
        hasMonster = _hasMonster;
    }

    // chest properties
    public boolean getHasChest() {
        return hasChest;
    }

    public void setHasChest(boolean _hasChest) {
        hasChest = _hasChest;
    }

    // The properties for setting the rooms text based image
    public RoomImage getRoomImage() {
        return roomImage;
    }

    public void setRoomImage(RoomImage temp) {
        roomImage = temp;
    }

    public String toString() {
        return roomImage;
    }

    
    // Name Properties
    public String getName() {
        return name;
    }
    
    public void setName(String _name) {
        name = _name;
    }
 

}