
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
    private GameManager gm = GameManager.getInstance();
    private static InputManager instance = null; 

    // private constructor restricted to this class itself 
    public InputManager() {
        currentRoom = null;
        previousRoom = null;
    }
    // static method to create instance of Singleton class InputManager 
    public static InputManager getInstance() 
    { 
        if (instance == null) {
            instance = new InputManager();  
        }
        return instance; 
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
    public void VerifyInput(Room cr) {
        System.out.println(cr.toString(cr.getHasMonster()));//draw room
        System.out.println("\n\t*You are now in " + cr.getName() + ".*");
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        if (!cr.getHasMonster()) {
            System.out.println("What would you like to do?");
            while (!isValid) {
                String input = scan.nextLine();
                switch (input.toLowerCase()) {
                // TODO: add "go [direction]" to the list of options
                case "north":
                case "go north":
                case "go forward":
                case "go up":
                case "up":
                case "forward":
                case "n":
                    isValid = true;
                    if (cr.getnDoor() != null) {
                        System.out.println("You move north");
                        previousRoom = cr;
                        currentRoom = cr.getnDoor();
                    } else {
                        System.out.println("You can't do that. Try a different direction or action.");
                    }
                    break;
                case "south":
                case "go south":
                case "go back":
                case "go down":
                case "back":
                case "down":
                case "s":
                    isValid = true;
                    if (cr.getsDoor() != null) {
                        System.out.println("You move south");
                        previousRoom = cr;
                        currentRoom = cr.getsDoor();
                    } else {
                        System.out.println("You can't do that. Try a different direction or action.");
                    }
                    break;
                case "east":
                case "go east":
                case "go right":
                case "right":
                case "e":
                    isValid = true;
                    if (cr.geteDoor() != null) {
                        System.out.println("You move east");
                        previousRoom = cr;
                        currentRoom = cr.geteDoor();
                    } else {
                        System.out.println("You can't do that. Try a different direction or action.");
                    }
                    break;
                case "west":
                case "go west":
                case "go left":
                case "left":
                case "w":
                    isValid = true;
                    if (cr.getwDoor() != null) {
                        System.out.println("You move west");
                        previousRoom = cr;
                        currentRoom = cr.getwDoor();
                    } else {
                        System.out.println("You can't do that. Try a different direction or action.");
                    }
                    break;
                case "help":
                case "h":
                    // TODO: Make help actually useful.
                    isValid = false;
                    System.out.println("Try typing in a direction or action you wish to attempt.");
                    break;
                case "status":
                case "stat":
                    isValid = false;
                    System.out.println(gm.player.toString());
                    break;
                case "quit":
                case "q":
                    isValid = true;
                    System.out.println("\nDo you want quit? (Y)es or (N)o");
                    input = scan.nextLine().toLowerCase();
                    if (input.equals("yes") || input.equals("y"))
                        scan.close();
                    else if (input.equals("no") || input.equals("n"))
                        break;
                default:
                    isValid = false;
                    System.out.println("Sorry I don't understand. What do you want to do?");
                    break;
                }
            }
        } else {
            gm.inCombat = true;
            // If the player is in combat they have fewer options.
            StartCombat(gm.player, currentRoom.getMonster());
        }
    }

    public void StartCombat(CharacterController player, CharacterController monster) {
        Scanner scan = new Scanner(System.in);
        int playerIntiative = 0, monsterIntiative = 0;
        playerIntiative = gm.player.RollInitiative();
        monsterIntiative = monster.RollInitiative();
        System.out.println("Entered combat with " + monster.getName() + "!\n");
        boolean isValid = false;
        while (gm.inCombat == true) {
            {
                isValid = false;
                if (playerIntiative > monsterIntiative) {
                    while (!isValid) {
                        System.out.println("What would you like to do?");
                        String input = scan.nextLine();
                        switch (input.toLowerCase()) {
                        case "attack":
                        case "a":
                            isValid = true;
                            // Player attacks first
                            Attack(player, monster);
                            break;
                        case "leave":
                        case "l":
                        case "run":
                        case "retreat":
                        case "flee":
                            isValid = true;
                            if (gm.player.RollInitiative() > monster.RollInitiative()) {
                                System.out.println("You escaped!");
                                monster.setHealth(monster.getMaxHealth()); // Reset monster health.
                                setCurrentRoom(getPreviousRoom()); // Returns player to the previous room.
                                gm.inCombat = false;
                            } else {
                                System.out.println(monster.getName() + " prevents your escape!");
                            }
                            break;
                        case "help":
                        case "h":
                            // TODO: Make help actually useful.
                            System.out.println("Try typing in a direction or action you wish to attempt.");
                            break;
                        case "status":
                        case "stat":
                            System.out.println(gm.player.toString());
                            break;
                        case "quit":
                        case "q":
                            System.out.println("\nDo you want quit? (Y)es or (N)o");
                            input = scan.nextLine().toLowerCase();
                            if (input.equals("yes") || input.equals("y")) {
                                isValid = true;
                                scan.close();
                                gm.inCombat = false;
                                break;
                            } else if (input.equals("no") || input.equals("n"))
                                break;
                        default:
                            System.out.println("You can't do that.");
                            break;
                        }
                    }
                    // if monster is still alive it attacks
                    if (gm.inCombat)
                        Attack(monster, player);
                } else {
                    // monster attacks first
                    if (gm.inCombat)
                        Attack(monster, player);
                    while (!isValid) {
                        // then player gets to respond
                        System.out.println("What would you like to do?");
                        String input = scan.nextLine();
                        switch (input.toLowerCase()) {
                        case "attack":
                        case "a":
                            isValid = true;
                            // Player attacks
                            Attack(player, monster);
                            break;
                        case "leave":
                        case "l":
                        case "run":
                        case "retreat":
                        case "flee":
                            isValid = true;
                            if (gm.player.RollInitiative() > monster.RollInitiative()) {
                                System.out.println("You escaped!");
                                monster.setHealth(monster.getMaxHealth()); // Reset monster health.
                                setCurrentRoom(getPreviousRoom()); // Returns player to the previous room.
                                gm.inCombat = false;
                            } else {
                                System.out.println(monster.getName() + "prevents your escape!");
                            }
                        case "help":
                        case "h":
                            // TODO: Make help actually useful.
                            System.out.println("Try typing in a direction or action you wish to attempt.");
                            break;
                        case "status":
                        case "stat":
                            System.out.println(gm.player.toString());
                            break;
                        case "quit":
                        case "q":
                            System.out.println("\nDo you want quit? (Y)es or (N)o");
                            input = scan.nextLine().toLowerCase();
                            if (input.equals("yes") || input.equals("y")) {
                                isValid = true;
                                scan.close();
                                gm.inCombat = false;
                                break;
                            } else if (input.equals("no") || input.equals("n"))
                                break;
                        default:
                            if (monster.getHealth() <= 0) {
                                gm.inCombat = false;
                                currentRoom.setHasMonster(false);
                                break;
                            }
                            isValid = true;
                            System.out.println("You do not attack.");
                            break;
                        }
                    }
                }
            }
        }
    }

    private void Attack(CharacterController attacker, CharacterController target) {
        if (attacker.getAttackRoll() > target.getArmorClass()) {
            int damage = attacker.getDamageRoll();
            target.setHealth(target.getHealth() - damage);
            System.out.println(attacker.getName() + " did " + damage + " damage to " + target.getName());

            if (target.getHealth() <= 0) {
                System.out.println(attacker.getName() + " defeated " + target.getName() + "!");
                if (attacker == gm.player) {
                    currentRoom.setHasMonster(false);
                } else {
                    GameOver();
                }
                gm.inCombat = false;
            }
        } else {
            System.out.println(attacker.getName() + " missed!");
        }
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
                        .println("Congratulations! You're a wizard " + gm.player.getName() + "! Here's your free wand.\n");
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
                System.out.println("You must be a programmer " + gm.player.getName() + ". Better start debugging.\n");
                break;
            default:
                System.out.println("Um... okay. But \"" + classAnswer.toLowerCase() + "\" wasn't one of the choices. "
                        + "So which do you think is mightier? The PEN or the SWORD?");
            }
        }
        gm.player.CharacterSprite();// set the players character sprite based on class chosen.
        System.out.println("Your current stats are: " + gm.player.toString());
        System.out.println("\nNow that you have provided all the necessary information "
                + "\nand waived the your right to hold the Adventurers' Guild liabile in the case of your death or dismemberment."
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
                // TODO: Add player death tracker.
                isValid = true;
                System.out.println("Okay then! Up you get, the blood should wash out eventually.");
                gm.player.setHealth(gm.player.getMaxHealth()); // Reset player health.
                currentRoom.getMonster().setHealth(currentRoom.getMonster().getMaxHealth()); // Reset monster health.
                setCurrentRoom(getPreviousRoom()); // Returns player to the previous room.
                gm.inCombat = false;
                break;
            case "no":
            case "n":
                isValid = true;
                System.out.print("Oh well. We can't all be winners.");
                scan.close();
                break;
            default:
                System.out.println("It's a yes or no question " + gm.player.getName() + ". (Y)es or (N)o");
                input = scan.nextLine();
                break;
            }
        }

    }
}