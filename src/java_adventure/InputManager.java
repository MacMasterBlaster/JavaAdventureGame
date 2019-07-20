
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
    private GameManager gm;

    public InputManager(GameManager _gm) {
        currentRoom = null;
        previousRoom = null;
        gm = _gm;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room _currentRoom) {
        currentRoom = _currentRoom;
    }

    public Room getPreviousRoom() {
        return previousRoom;
    }

    public void setPreviousRoom(Room _previousRoom) {
        previousRoom = _previousRoom;
    }

    // Compares user input against possible acceptable values.
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
                } else {
                    System.out.println("You can't do that. Try a different direction or action.");
                }
                break;
            case "south":
            case "s":
                // isValid = true;
                if (currentRoom.getsDoor() != null) {
                    System.out.println("You move south");
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getsDoor();
                } else {
                    System.out.println("You can't do that. Try a different direction or action.");
                }
                break;
            case "east":
            case "e":
                // isValid = true;
                if (currentRoom.geteDoor() != null) {
                    System.out.println("You move east");
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.geteDoor();
                } else {
                    System.out.println("You can't do that. Try a different direction or action.");
                }
                break;
            case "west":
            case "w":
                // isValid = true;
                if (currentRoom.getwDoor() != null) {
                    System.out.println("You move west");
                    previousRoom = currentRoom;
                    currentRoom = currentRoom.getwDoor();
                } else {
                    System.out.println("You can't do that. Try a different direction or action.");
                }
                break;
            case "help":
            case "h":
                // isValid = false;
                System.out.println("Try typing in a direction or action you wish to attempt.");
                break;
            case "status":
            case "stat":
                // isValid = false;
                // TODO: Added references to player to GameManager class
                // System.out.println(gm.player.toString());
                break;
            case "quit":
            case "q":
                System.out.println("\nDo you want quit? (Y)es or (N)o");
                input = scan.nextLine().toLowerCase();
                if (input.equals("yes") || input.equals("y"))
                    scan.close();
                else if (input.equals("no") || input.equals("n"))
                    break;
            default:
                // isValid = false;
                System.out.println("Sorry I don't understand. What do you want to do?");
                break;
            }
        }
        scan.close();
    }

    // This method should be called when new game is started.
    public void Welcome() {
        boolean isValid = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("Greetings would-be adventurer! Before you begin your "
                + "quest, \nwe need some personal information. (For liabilty purposes)" + "\nWhat is your name? ");
        String newName = scan.nextLine();
        gm.player.setName(newName);
        System.out.println("Great! Just a few more questions. \nDo you have any next of kin " + gm.player.getName()
                + "? (Y)es or (N)o");
        while (!isValid) {
            String answer = scan.nextLine();
            switch (answer.toLowerCase()) {
            case "yes":
            case "y":
                isValid = true;
                System.out.println("Well thats unfortunate. I hope they aren't expecting you back in time for dinner.");
                break;
            case "no":
            case "n":
                isValid = true;
                System.out.print("Excellent! ");
                break;
            default:
                System.out.println("It's a yes or no question... So do you have any next of kin " + gm.player.getName()
                        + "? (Y)es or (N)o");
                break;
            }
        }
        isValid = false;
        System.out.println("One last question. Which do you think is mighter? The pen or the sword?");
        while (!isValid) {
            String classAnswer = scan.nextLine();
            switch (classAnswer.toLowerCase()) {
            case "p":
            case "pen":
                isValid = true;
                gm.MakeWizard(gm.player, gm.player.getName());
                System.out
                        .println("Congratulations! Your a wizard " + gm.player.getName() + "! Here's your free wand.\n");
                break;
            case "s":
            case "sword":
                isValid = true;
                gm.MakeWarrior(gm.player, gm.player.getName());
                System.out.println("Might makes right! I always say. Well " + gm.player.getName()
                        + ", here's your free sword and shield.\n");
                break;
            case "c":
            case "code":
                isValid = true;
                gm.MakeGod(gm.player, gm.player.getName());
                System.out.println("You must be a programmer " + gm.player.getName()
                        + ". Better start debugging.\n");
                break;
            default:
                System.out.println("Um... okay. But \"" + classAnswer.toLowerCase() + "\" wasn't one of the choices. "
                        + "Which do you think is mightier? The PEN or the SWORD?");
            }
        }
        System.out.println("Your current stats are: " + gm.player.toString());
        System.out.println("Now that you have provided all the necessary information "
                + "\nand waived the Adventurers' Guild of all liability in the case of your death or dismemberment."
                + "\nWe wish you luck in your conquest of the dungeon of the Terrible Javalang.");
        scan.nextLine();
    }

    // This method should be called on player death.
    public void GameOver() {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        System.out.println(
                "\nWell that could have gone better. \nWould you like to restart from the previous room? (Y)es or (N)o");
        String input = scan.next();
        while (!isValid) {
            switch (input.toLowerCase()) {
            case "yes":
            case "y":
                isValid = true;
                System.out.println("Okay then! Up you get, the blood should wash out eventually.");
                // TODO: restore player and previous enemy to full health and place player in previous room. Increment a death counter.
                break;
            case "no":
            case "n":
                System.out.print("Oh well. We can't all be winners.");
                scan.close();
                break;
            default:
                System.out.println("It's a yes or no question " + gm.player.getName() + ". (Y)es or (N)o");
                break;
            }
        }

    }
}