
// ***********************************************
// InputManager.java
// Name: Mac Orchard
//
// Manages all user input. Verifying input validity 
// and providing input hints as needed.
// ***********************************************
package java_adventure;

import java.util.Scanner;

public class InputManager {
    
    private Room currentRoom, previousRoom;

    public InputManager(){
        currentRoom = null;
        previousRoom = null;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room _currentRoom) {
        currentRoom = _currentRoom;
    }

    public Room getPreviousRoom() {
        return currentRoom;
    }
    
    public void setPreviousRoom(Room _previousRoom) {
        previousRoom = _previousRoom;
    }

    // Compares user input against possible acceptable values.
    // TODO Figure out how to define which inputs are valid for a given room.
    public void VerifyInput(Room currentRoom) {
        System.out.println("What would you like to do?");
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        while (isValid == false) {
            String input = scan.nextLine();
            switch (input.toLowerCase()) {
            case "north":
            case "n":
                // isValid = true;
                if (currentRoom.getnDoor() != null) {
                    System.out.println("You move north");
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getnDoor();
                }
                else{
                    System.out.println("You can't do that. Try a different direction or look around.");
                }
                break;
            case "south":
            case "s":
                // isValid = true;
                if (currentRoom.getsDoor() != null) {
                    System.out.println("You move south");
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getsDoor();
                }
                else{
                    System.out.println("You can't do that. Try a different direction or look around.");
                }
                break;
            case "east":
            case "e":
                // isValid = true;
                if (currentRoom.geteDoor() != null) {
                    System.out.println("You move east");
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.geteDoor();
                }
                else{
                    System.out.println("You can't do that. Try a different direction or look around.");
                }
                break;
            case "west":
            case "w":
                // isValid = true;
                if (currentRoom.getwDoor() != null) {
                    System.out.println("You move west");
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getwDoor();
                }
                else{
                    System.out.println("You can't do that. Try a different direction or look around.");
                }
                break;
            case "help":
            case "h":
                // isValid = false;
                System.out.println("Try typing in a direction or action you wish to attempt.");
                break;
            default:
                // isValid = false;
                System.out.println("Sorry I don't understand. What do you want to do?");
                break;
            }
        }
        scan.close();
    }
}