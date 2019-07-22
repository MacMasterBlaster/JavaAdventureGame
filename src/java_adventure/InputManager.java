
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
            System.out.print("    What would you like to do? ");
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
                    isValid = false;
                    System.out.println("Try typing in a direction or action you wish to attempt.");
                    System.out.println("For a full list of commands, type \"comm\"");
                    System.out.println("Type \"shr\" for a list of command shortcuts.");
                    input = scan.nextLine();
                    switch (input.toLowerCase()) {
                               case "comm":
                                  isValid = false;
                                  System.out.println("-Movement- \n North: (go) north, up, forward\n South: (go) south, down, back\n " +
                                  "East:  (go) east, right\n West:  (go) west, left\n"  +
                                  "-Combat-\n Attack:  attack\n Retreat: leave, run, retreat, flee\n View Status: (Works outside of combat): status\n" + 
                                  "-Options-\n Quit (Warning: Stops the game): quit");
                              break; 
                              case "shr":
                                  isValid = false;
                                  System.out.println("Don't want to waste any time eh?\n-Movement-\n North: n\n South: s\n East:  e\n West:  w\n" +
                                  "-Combat-\n Attack:  a \n Retreat: l \n Status:  stat \n" +
                                  "-Options-\n Status: stat \n Quit:   q \n ");
                              break;
                              default:
                                  System.out.println("Got your bearings?");
                             break;
                            }                   
                    break;
                case "status":
                case "stat":
                    isValid = false;
                    System.out.println(gm.player.toString());
                    scan.nextLine();
                    ClearConsole();
                    System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room\
                    System.out.print("    What would you like to do? ");
                    break;
                // TODO: Remove MONSTAT case
                case "monstat":
                    isValid = false;
                    if (currentRoom.getHasMonster() == true)
                        System.out.println(currentRoom.getMonster().toString());
                    scan.nextLine();
                    ClearConsole();
                    System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                    System.out.print("    What would you like to do? ");
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
                        System.out.print("    What would you like to do? ");
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
                            System.out.println("Try typing in a direction or action you wish to attempt.");
                            System.out.println("For a full list of commands, type \"comm\"");
                            System.out.println("Type \"shr\" for a list of command shortcuts.");
                            input = scan.nextLine();
                            switch (input.toLowerCase()) {
                                       case "comm":
                                          isValid = false;
                                          System.out.println("-Movement- \n North: (go) north, up, forward\n South: (go) south, down, back\n " +
                                          "East:  (go) east, right\n West:  (go) west, left\n"  +
                                          "-Combat-\n Attack:  attack\n Retreat: leave, run, retreat, flee\n View Status: (Works outside of combat): status\n" + 
                                          "-Options-\n Quit (Warning: Stops the game): quit");
                                       break; 
                                       case "shr":
                                          isValid = false;
                                          System.out.println("Don't want to waste any time eh?\n-Movement-\n North: n\n South: s\n East:  e\n West:  w\n" +
                                          "-Combat-\n Attack:  a \n Retreat: l \n Status:  stat \n" +
                                          "-Options-\n Status: stat \n Quit:   q \n ");
                                       break;
                                       default:
                                          System.out.println("Got your bearings?");
                                       break;
                                  }   
                            break;
                        case "status":
                        case "stat":
                            isValid = false;
                            System.out.println(gm.player.toString());
                            scan.nextLine();
                            ClearConsole();
                            System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                            System.out.print("    What would you like to do? ");
                            break;
                        // TODO: Remove MONSTAT case
                        case "monstat":
                            isValid = false;
                            if (currentRoom.getHasMonster() == true)
                                System.out.println(currentRoom.getMonster().toString());
                            scan.nextLine();
                            ClearConsole();
                            System.out.println(currentRoom.toString(currentRoom.getHasMonster()));// draw room
                            System.out.print("    What would you like to do? ");
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
                        System.out.print("    What would you like to do? ");
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
                            System.out.println("Try typing in a direction or action you wish to attempt.");
                            System.out.println("For a full list of commands, type \"comm\"");
                            System.out.println("Type \"shr\" for a list of command shortcuts.");
                            input = scan.nextLine();
                            switch (input.toLowerCase()) {
                                        case "comm":
                                           isValid = false;
                                           System.out.println("-Movement- \n North: (go) north, up, forward\n South: (go) south, down, back\n " +
                                           "East:  (go) east, right\n West:  (go) west, left\n"  +
                                           "-Combat-\n Attack:  attack\n Retreat: leave, run, retreat, flee\n View Status: (Works outside of combat): status\n" + 
                                           "-Options-\n Quit (Warning: Stops the game): quit");
                                       break; 
                                       case "shr":
                                           isValid = false;
                                           System.out.println("Don't want to waste any time eh?\n-Movement-\n North: n\n South: s\n East:  e\n West:  w\n" +
                                           "-Combat-\n Attack:  a \n Retreat: l \n Status:  stat \n" +
                                           "-Options-\n Status: stat \n Quit:   q \n ");
                                       break;
                                       default:
                                           System.out.println("Got your bearings?");
                                      break;
                                     }   
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
        System.out.println("\n\n\n\t\t\t _______ _               _____                                     \n"
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
        System.out.print("You have decided to attempt to join the Adventures' Guild for the first time. It is a massive and \n" 
        +"imposing building teaming with people, all of whom appear to better equipped than you. You make your way to \n"
        + "the front desk where a portly, smiling man with a thick beard sits waiting patiently. Before you have a chance to"
        + "\neven speak, he says \"Greetings would-be adventurer! Before you can begin a your life as a "
        + "\nmember of the Adventures' Guild, we need some personal information. For liabilty purposes.\"" + "\n\n\"What is your name?\" ");
        String newName = scan.nextLine();
        if (!newName.equals(""))gm.player.setName(newName);
        System.out.print("\n\"Good, good! Just a few more questions. Do you have any next of kin " + gm.player.getName()
                + "?\" (Y)es or (N)o: ");
        while (!isValid) {
            String answer = scan.nextLine();
            switch (answer.toLowerCase()) {
            case "yes":
            case "y":
                isValid = true;
                System.out.println("\n\"Well thats unfortunate. I hope they aren't expecting you back in time for dinner.\"");
                break;
            case "no":
            case "n":
                isValid = true;
                System.out.println("\n\"Excellent!\" He says smiling even more broadly. ");
                break;
            default:
                System.out.print("\n\"It's a yes or no question... So do you have any next of kin " + gm.player.getName()
                        + "?\" (Y)es or (N)o: ");
                break;
            }
        }
        isValid = false;
        System.out.print("\n\"One last question. Which do you think is mighter? The pen or the sword?\" ");
        while (!isValid) {
            String classAnswer = scan.nextLine();
            switch (classAnswer.toLowerCase()) {
            case "p":
            case "pen":
                isValid = true;
                gm.MakeWizard(gm.player, gm.player.getName());
                System.out.println(
                        "\"\nCongratulations! You're a wizard " + gm.player.getName() + "! Here's your free wand.\""
                        +"\nHe hands you a stick of questionable value.\n");
                break;
            case "s":
            case "sword":
                isValid = true;
                gm.MakeWarrior(gm.player, gm.player.getName());
                System.out.println("\n\"Might makes right! I always say. Well " + gm.player.getName()
                        + ", here's your free sword and shield.\" He says smiling."
                        + "\nHe hands you a sword and shield that have definitely seen better days.\n");
                break;
            case "c":
            case "code":
                isValid = true;
                gm.MakeGod(gm.player, gm.player.getName());
                System.out.println("\n\"You must be a programmer " + gm.player.getName() + ". Better start debugging.\"\n");
                break;
            default:
                System.out.println("\nFrowning the man says, \"Um... okay. But \"" + classAnswer.toLowerCase() + "\" wasn't one of the choices. "
                        + "So which do you think is mightier? The PEN or the SWORD?\" ");
            }
        }
        gm.player.CharacterSprite();// set the players character sprite based on class chosen.
        System.out.println(gm.player.toString());
        System.out.print("\nHe takes all the paperwork you filled out and gets out of his chair."
                + "\n\"Now that you have provided all the necessary information and waived the your right"
                + "\nto hold the Adventurers' Guild liable in the case of your death or dismemberment.\""
                +"\nHe says still smiling. \"We wish you the best of luck in your conquest of the dungeon"
                + "\nof the Terrible Javalang.\" He gives you a map and begins to shove you out the door with your \"new\""
                +"\nequipment clutched awkwardly in your arms."
                + "\n\n Time seems to pass in a blur. Next thing you know you are standing before the entrance to a"
                + "\ncave located right where the map said it would be.\n\n Do you dare to enter? (Y)es or (N)o: ");
        String input = scan.nextLine();
        isValid = false;
        while (!isValid) {
            switch (input.toLowerCase()) {
            case "y":
            case "yes":
                ClearConsole();
                isValid = true;
                gm.beginQuest = true;
                break;
            case "n":
            case "no":
            isValid = true;
                gm.beginQuest = false;
                System.out.println("\nAlright, you go home and live a boring life. THE END\n");
                gm.player.setHealth(0);
                scan.close();
                break;
            default:
                System.out.print("\nIt's a yes or no question " + gm.player.getName() + ". (Y)es or (N)o: ");
                input = scan.nextLine();
                break;
            }
        }
    }

    // This method should be called on player death.
    public void GameOver() throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        if (gm.player.getHealth() <= 0) {
            gm.playerDeaths++;
            if (gm.playerDeaths > 1) {
                System.out.print("\nWell that could have gone better. On the bright side, you've only experienced a painful death "
                                + gm.playerDeaths + " times!\n\nWould you like to restart from the previous room? (Y)es or (N)o: ");
            } else {
                System.out.print("\nWell that could have gone better. On the bright side, you've only experienced a painful death "
                                + gm.playerDeaths + " time!\n\nWould you like to restart from the previous room? (Y)es or (N)o: ");
            }

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
                    gm.player.setHealth(0);
                    System.out.print("Oh well. We can't all be winners.\n");
                    // scan.nextLine();
                    scan.close();
                }
                break;
            case "n":
            case "no":
                isValid = true;
                // if player dies
                if (gm.player.getHealth() <= 0) {
                    System.out.print("Oh well. We can't all be winners.\n");
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

    // This method should be called on player win.
    public void Win(Scanner scan) throws IOException, InterruptedException {
        ClearConsole();

        gm.player.setHealth(0);
        scan.close(); // This will cause the game to end.
    }

}