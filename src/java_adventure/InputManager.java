
// ***********************************************
// InputManager.java
// Name: Mac Orchard
//
// Manages all user input. Verifying input validity 
// and providing input hints as needed.
// ***********************************************
package java_adventure;

import java.util.Scanner;
import java.io.IOException;

public class InputManager {

    private Room currentRoom, previousRoom;
    private GameManager gm = GameManager.getInstance();
    private static InputManager instance = null;

    // private constructor restricted to this class itself
    public InputManager() {
        currentRoom = null;
        previousRoom = null;
    }

    // region Properties
    // static method to create instance of Singleton class InputManager
    public static InputManager getInstance() {
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

    // endregion
    private void ClearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // clears the console window.
    }

    // Compares user input against possible acceptable values.
    public void VerifyInput(Room cr) throws IOException, InterruptedException {
        // System.out.println("\n\t*You are now in " + cr.getName() + ".*"); //Intended
        // for debugging only.
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        if (!cr.getHasMonster()) {
            System.out.print("What would you like to do? ");
            while (!isValid) {
                String input = scan.nextLine();
                switch (input.toLowerCase()) {
                case "north":
                case "go north":
                case "go forward":
                case "go up":
                case "up":
                case "forward":
                case "n":
                    isValid = true;
                    if (cr.getnDoor() != null) {
                        ClearConsole();
                        previousRoom = cr;
                        currentRoom = cr.getnDoor();
                        System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                        System.out.println("\t*You moved north*");
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
                        ClearConsole();
                        previousRoom = cr;
                        currentRoom = cr.getsDoor();
                        System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                        System.out.println("\t*You moved south*");
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
                        ClearConsole();
                        previousRoom = cr;
                        currentRoom = cr.geteDoor();
                        System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                        System.out.println("\t*You moved east*");
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
                        ClearConsole();
                        previousRoom = cr;
                        currentRoom = cr.getwDoor();
                        System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                        System.out.println("\t*You moved west*");
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
                    scan.nextLine();
                    ClearConsole();
                    System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room\
                    System.out.print("What would you like to do? ");
                    break;
                // TODO: Remove MONSTAT case
                case "monstat":
                    isValid = false;
                    if (currentRoom.getHasMonster() == true)
                        System.out.println(currentRoom.getMonster().toString());
                    scan.nextLine();
                    ClearConsole();
                    System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                    System.out.print("What would you like to do? ");
                    break;
                case "die":
                    if (gm.player.getCharClass().equals("God")) {
                        isValid = true;
                        System.out.print("You die.");
                        gm.player.setHealth(0);
                        scan.nextLine();
                    }
                case "quit":
                case "q":
                    isValid = true;
                    GameOver();
                    break;
                case "jumpto": // For Debugging ONLY! Allows player to jump to any room in the dungeon.
                    if (gm.player.getCharClass().equals("God")) {
                        isValid = true;
                        System.out.print("What room do you want to jump to? [0 - " + gm.dungeon.size() + "]: ");
                        int room = scan.nextInt();
                        currentRoom = gm.dungeon.get(room);
                    }
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

    public void StartCombat(CharacterController player, CharacterController monster)
            throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        int playerIntiative = 0, monsterIntiative = 0;
        playerIntiative = gm.player.RollInitiative();
        monsterIntiative = monster.RollInitiative();
        System.out.println("\t*Entered combat with " + monster.getName() + "!*\n");
        boolean isValid = false;
        while (gm.inCombat == true) {
            {
                isValid = false;
                if (playerIntiative > monsterIntiative) {
                    while (!isValid) {
                        System.out.print("What would you like to do? ");
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
                                System.out.println("\t*You escaped!*");
                                monster.setHealth(monster.getMaxHealth()); // Reset monster health.
                                setCurrentRoom(getPreviousRoom()); // Returns player to the previous room.
                                ClearConsole();
                                System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                                gm.inCombat = false;
                            } else {
                                System.out.println("\t*" + monster.getName() + "prevents your escape!*");
                            }
                            break;
                        case "help":
                        case "h":
                            // TODO: Make help actually useful.
                            System.out.println("Try typing in a direction or action you wish to attempt.");
                            break;
                        case "status":
                        case "stat":
                            isValid = false;
                            System.out.println(gm.player.toString());
                            scan.nextLine();
                            ClearConsole();
                            System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                            System.out.print("What would you like to do? ");
                            break;
                        // TODO: Remove MONSTAT case
                        case "monstat":
                            isValid = false;
                            if (currentRoom.getHasMonster() == true)
                                System.out.println(currentRoom.getMonster().toString());
                            scan.nextLine();
                            ClearConsole();
                            System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                            System.out.print("What would you like to do? ");
                            break;
                        case "quit":
                        case "q":
                            isValid = true;
                            GameOver();
                            break;
                        default:
                            if (gm.inCombat) {
                                System.out.println("You do not attack.");
                                Attack(monster, player);
                                break;
                            }
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
                        System.out.print("What would you like to do? ");
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
                        case "run away":
                        case "retreat":
                        case "flee":
                            isValid = true;
                            if (gm.player.RollInitiative() > monster.RollInitiative()) {
                                System.out.println("\t*You escaped!*");
                                monster.setHealth(monster.getMaxHealth()); // Reset monster health.
                                setCurrentRoom(getPreviousRoom()); // Returns player to the previous room.
                                ClearConsole();
                                System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                                gm.inCombat = false;
                            } else {
                                System.out.println("\t*" + monster.getName() + "prevents your escape!*");
                            }
                            break;
                        case "help":
                        case "h":
                            // TODO: Make help actually useful.
                            System.out.println("Try typing in a direction or action you wish to attempt.");
                            break;
                        case "status":
                        case "stat":
                            isValid = false;
                            System.out.println(gm.player.toString());
                            scan.nextLine();
                            ClearConsole();
                            System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                            break;
                        case "monstat":
                            isValid = false;
                            if (currentRoom.getHasMonster() == true)
                                System.out.println(currentRoom.getMonster().toString());
                            scan.nextLine();
                            ClearConsole();
                            System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                            break;
                        case "quit":
                        case "q":
                            isValid = true;
                            GameOver();
                            break;
                        default:
                            if (monster.getHealth() <= 0) {
                                gm.inCombat = false;
                                currentRoom.setHasMonster(false);
                                break;
                            }
                            isValid = true;
                            System.out.println("\t*You do not attack.*");
                            break;
                        }
                    }
                }
            }
        }
    }

    private void Attack(CharacterController attacker, CharacterController target)
            throws IOException, InterruptedException {
        if (attacker.getAttackRoll() > target.getArmorClass()) {
            int damage = attacker.getDamageRoll();
            target.setHealth(target.getHealth() - damage);
            System.out.println("\t*" + attacker.getName() + " did " + damage + " damage to " + target.getName() + ".*");

            if (target.getHealth() <= 0) {
                if (attacker == gm.player) {
                    currentRoom.setHasMonster(false);
                    ClearConsole();
                    System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                    System.out.println("\t*" + attacker.getName() + " defeated " + target.getName() + "!*");
                    VerifyInput(currentRoom);
                } else {
                    System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                    System.out.println("\t*" + attacker.getName() + " defeated " + target.getName() + "!*");
                    GameOver();
                }
                gm.inCombat = false;
            }
        } else {
            System.out.println("\t*" + attacker.getName() + " missed!*");
        }
    }

    // This method should be called when new game is started.
    public void Welcome() throws IOException, InterruptedException {
        boolean isValid = false;
        Scanner scan = new Scanner(System.in);
        // prints the title image.
        System.out.println("\t\t\t _______ _               _____                                     \n"
                + "\t\t\t|__   __| |             |  __ \\                                    \n"
                + "\t\t\t   | |  | |__   ___     | |  | |_   _ _ __   __ _  ___  ___  _ __  \n"
                + "\t\t\t   | |  | '_ \\ / _ \\    | |  | | | | | '_ \\ / _` |/ _ \\/ _ \\| '_ \\ \n"
                + "\t\t\t   | |  | | | |  __/    | |__| | |_| | | | | (_| |  __/ (_) | | | |\n"
                + "\t\t\t   |_|  |_| |_|\\___|    |_____/ \\__,_|_| |_|\\__, |\\___|\\___/|_| |_|\n"
                + "\t\t\t                                             __/ |                 \n"
                + "\t\t\t                                            |___/                  \n" + "\n"
                + "\t\t\t            __            _                  _                   \n"
                + "\t\t\t           / _|          | |                | |                  \n"
                + "\t\t\t      ___ | |_           | | __ ___   ____ _| | __ _ _ __   __ _ \n"
                + "\t\t\t     / _ \\|  _|      _   | |/ _` \\ \\ / / _` | |/ _` | '_ \\ / _` |\n"
                + "\t\t\t    | (_) | |       | |__| | (_| |\\ V / (_| | | (_| | | | | (_| |\n"
                + "\t\t\t     \\___/|_|        \\____/ \\__,_| \\_/ \\__,_|_|\\__,_|_| |_|\\__, |\n"
                + "\t\t\t                                                            __/ |\n"
                + "\t\t\t                                                           |___/ \n" + "\n");
        System.out.println("\t\t\t\t\t\tPress Enter to Start!");
        scan.nextLine();
        ClearConsole();
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
                System.out.println(
                        "Congratulations! You're a wizard " + gm.player.getName() + "! Here's your free wand.\n");
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
        scan.nextLine();
        System.out.println("\nNow that you have provided all the necessary information "
                + "\nand waived the your right to hold the Adventurers' Guild liabile in the case of your death or dismemberment."
                + "\nWe wish you luck in your conquest of the dungeon of the Terrible Javalang.");
        scan.nextLine();
        ClearConsole();
    }

    // This method should be called on player death.
    int playerDeaths = 0;
    public void GameOver() throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        playerDeaths++;
        if (gm.player.getHealth() <= 0) {
            System.out.print("\nWell that could have gone better. On the bright side, you've only experienced a painful death " 
                    + playerDeaths + " time(s)!\n"
                    + "\nWould you like to restart from the previous room? (Y)es or (N)o: ");
        } else {
            System.out.print("\nDo you want quit? (Y)es or (N)o: ");
        }
        String input = scan.next();
        while (!isValid) {
            switch (input.toLowerCase()) {
            case "y":
            case "yes":
                // TODO: Add player death tracker.
                isValid = true;
                // if player dies
                if (gm.player.getHealth() <= 0) {
                    ClearConsole();
                    gm.player.setHealth(gm.player.getMaxHealth()); // Reset player health.
                    if (currentRoom.getHasMonster() != false) {
                        currentRoom.getMonster().setHealth(currentRoom.getMonster().getMaxHealth());
                    } // Reset monster health.
                    if (previousRoom != null) {
                        currentRoom = previousRoom; // Returns player to the previous room.
                    }
                    System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                    System.out.println("Okay then! Up you get, the blood should wash out eventually.");
                    gm.inCombat = false;
                    VerifyInput(currentRoom);
                } else {
                    // player attempts to quit
                    gm.inCombat = false;
                    System.out.print("(1)Oh well. We can't all be winners.\n");
                    //scan.nextLine();
                    scan.close();
                }
                break;
            case "n":
            case "no":
                isValid = true;
                // if player dies
                if (gm.player.getHealth() <= 0) {
                    System.out.print("(2)Oh well. We can't all be winners.\n");
                    scan.nextLine();
                    scan.close();
                } else {
                    ClearConsole();
                    VerifyInput(currentRoom);
                }
                break;
            default:
                System.out.print("It's a yes or no question " + gm.player.getName() + ". (Y)es or (N)o: ");
                input = scan.nextLine();
                break;
            }
        }
    }
}