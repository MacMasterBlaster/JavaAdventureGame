
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

    public static void main(String[] args) {
        // System.out.println(input);
        // System.out.print("length: " + input.length());
        //VerifyInput();
    }

    // Compares user input against possible acceptable values.
    // TODO Figure out how to define which inputs are valid for a given room.
    public static void VerifyInput(Room currentRoom) {
        System.out.println("What would you like to do?");
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        boolean hasDoor = true;
        while (isValid == false) {
            String input = scan.nextLine();
            switch (input.toLowerCase()) {
            case "north":
            case "n":
                isValid = true;
                if (currentRoom.nDoor) {
                    System.out.println("You move north");
                }
                else{
                    System.out.println("You can't do that. Try a different direction or look around.");
                }
                break;
            case "south":
            case "s":
                isValid = true;
                if (currentRoom.sDoor) {
                    System.out.println("You move south");
                }
                else{
                    System.out.println("You can't do that. Try a different direction or look around.");
                }
                break;
            case "east":
            case "e":
                isValid = true;
                if (currentRoom.eDoor) {
                    System.out.println("You move east");
                }
                else{
                    System.out.println("You can't do that. Try a different direction or look around.");
                }
                break;
            case "west":
            case "w":
                isValid = true;
                if (currentRoom.wDoor) {
                    System.out.println("You move west");
                }
                else{
                    System.out.println("You can't do that. Try a different direction or look around.");
                }
                break;
            case "help":
            case "h":
                isValid = false;
                System.out.println("Try typing in a direction or action you wish to attempt.");
                break;
            default:
                isValid = false;
                System.out.println("Sorry I don't understand. What do you want to do?");
                break;
            }
        }
        scan.close();
    }
}