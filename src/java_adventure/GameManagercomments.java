// *****************************************************
// GameManager.java

// Manages game states, player and enemy creation, and 
// level position.
// *****************************************************
package java_adventure;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
    ArrayList<Room> dungeon = new ArrayList<Room>();
    CharacterController player = new CharacterController("Nobody", "None");
    private boolean inCombat = false;

    public boolean getInCombat() {
        return inCombat;
    }
    
    public void setInCombat(boolean temp) {
        inCombat = temp;
    }
    // region Player Classes
    public void MakeWizard(CharacterController newCharacter, String name) {
        newCharacter.setHealth(15);
        newCharacter.setMaxHealth(15);
        newCharacter.setArmorClass(8);
        newCharacter.setDamageDie(6);
        newCharacter.setDamageMod(5);
        newCharacter.setAttackMod(5);
        newCharacter.setCharClass("Wizard");
    }

    public void MakeWarrior(CharacterController newCharacter, String name) {
        newCharacter.setHealth(30);
        newCharacter.setMaxHealth(30);
        newCharacter.setArmorClass(15);
        newCharacter.setDamageDie(10);
        newCharacter.setDamageMod(2);
        newCharacter.setAttackMod(6);
        newCharacter.setCharClass("Warrior");
    }

    // For play testing only!
    public void MakeGod(CharacterController newCharacter, String name) {
        newCharacter.setHealth(1000);
        newCharacter.setMaxHealth(1000);
        newCharacter.setArmorClass(100);
        newCharacter.setDamageDie(100);
        newCharacter.setDamageMod(100);
        newCharacter.setAttackMod(100);
        newCharacter.setCharClass("God");
    }

    // endregion

    // region Enemies
    public void MakeGoblin(CharacterController newCharacter, String name) {
        newCharacter.setHealth(7);
        newCharacter.setMaxHealth(7);
        newCharacter.setArmorClass(10);
        newCharacter.setDamageDie(5);
        newCharacter.setDamageMod(2);
        newCharacter.setAttackMod(3);
        newCharacter.setCharClass("Goblin");
    }

    public void MakeSlime(CharacterController newCharacter, String name) {
        newCharacter.setHealth(25);
        newCharacter.setMaxHealth(25);
        newCharacter.setArmorClass(20);
        newCharacter.setDamageDie(4);
        newCharacter.setDamageMod(3);
        newCharacter.setAttackMod(4);
        newCharacter.setCharClass("Slime");
    }

    public void MakeMimic(CharacterController newCharacter, String name) {
        newCharacter.setHealth(18);
        newCharacter.setMaxHealth(18);
        newCharacter.setArmorClass(10);
        newCharacter.setDamageDie(10);
        newCharacter.setDamageMod(1);
        newCharacter.setAttackMod(10);
        newCharacter.setCharClass("Mimic");
    }

    public void MakeSpider(CharacterController newCharacter, String name) {
        newCharacter.setHealth(25);
        newCharacter.setMaxHealth(25);
        newCharacter.setArmorClass(20);
        newCharacter.setDamageDie(0);
        newCharacter.setDamageMod(0);
        newCharacter.setAttackMod(0);
        newCharacter.setCharClass("Spider");
    }

    public void MakeKnight(CharacterController newCharacter, String name) {
        newCharacter.setHealth(40);
        newCharacter.setMaxHealth(40);
        newCharacter.setArmorClass(22);
        newCharacter.setDamageDie(12);
        newCharacter.setDamageMod(6);
        newCharacter.setAttackMod(8);
        newCharacter.setCharClass("Knight");
    }
    // endregion

    public void RoomCreationTest() {
        Room start = new Room();
        Room moveAssit = new Room();
        Room fight = new Room();
        Room empty1 = new Room();
        Room empty2 = new Room();
        Room empty3 = new Room();
        Room slime1 = new Room();
        Room slime2 = new Room();
        Room chest1 = new Room();
        Room chest2 = new Room();
        Room mimic = new Room();
        Room spider = new Room();
        Room empty4 = new Room();
        Room boss = new Room();
        Room treasure = new Room();
        Room end = new Room();
        // Set all room linkages
        start.seteDoor(moveAssit);
        start.setRoomImage(null);
        moveAssit.setExits(fight, null, null, start);
        moveAssit.setRoomImage(null);
        fight.setExits(empty1, null, moveAssit, null);
        fight.setRoomImage(null);
        //fight.setHasEnemy(true);// this could be changed to a enemy object instead.
        //fight.setRoomImage(null);
        empty1.setExits(empty3, empty2, fight, null);
        empty1.setRoomImage(null);
        empty2.setExits(slime1, slime2, null, empty1);
        empty2.setRoomImage(null);
        empty3.setExits(null, slime1, empty1, null);
        empty3.setRoomImage(null);
        slime1.setExits(null, chest2, empty2, empty3);
        slime1.setRoomImage(null);
        slime2.setExits(null, null, mimic, empty2);
        slime2.setRoomImage(null);
        chest1.setExits(null, mimic, null, null);
        chest1.setRoomImage(null);
        chest2.setExits(null, slime1, null, null);
        chest2.setRoomImage(null);
        mimic.setExits(slime2, null, spider, null);
        mimic.setRoomImage(null);
        spider.setExits(mimic, empty4, null, null);
        spider.setRoomImage(null);
        empty4.setExits(boss, null, null, empty4);
        empty4.setRoomImage(null);
        boss.setExits(treasure, null, empty4, null);
        boss.setRoomImage(null);
        
        // Add all rooms to the dungeon list
        dungeon.add(start);
        dungeon.add(moveAssit);
        dungeon.add(fight);
        dungeon.add(empty1);
        dungeon.add(empty2);
        dungeon.add(empty3);
        dungeon.add(slime1);
        dungeon.add(slime2);
        dungeon.add(chest1);
        dungeon.add(chest2);
        dungeon.add(mimic);
        dungeon.add(spider);
        dungeon.add(empty4);
        dungeon.add(boss);
        dungeon.add(treasure);
        dungeon.add(end);
    }

    public void StartCombat(CharacterController player, CharacterController monster) {
        int playerIntiative = 0, monsterIntiative = 0;
        playerIntiative = player.RollInitiative();
        monsterIntiative = monster.RollInitiative();
        boolean inCombat = true;
        System.out.println("Entered combat with " + monster.getName() + "!");
        while (inCombat == true) {
            {
                if (playerIntiative > monsterIntiative) {
                    System.out.println("What would you like to do?");
                    Scanner scan = new Scanner(System.in);
                    String input = scan.nextLine();
                    switch (input.toLowerCase()) {
                    case "attack":
                    case "a":
                        // Player attacks first
                        Attack(player, monster);
                        break;
                    case "leave":
                    case "l":
                        if (player.RollInitiative() > monster.RollInitiative()) {
                            System.out.println("You escaped!");
                            //TODO: player returns to previous room
                            inCombat = false;
                        } else {
                            System.out.println(monster.getName() + "prevents your escape!");
                        }
                    default:
                        System.out.println("You do not attack.");
                        break;
                    }
                    // monster attack
                    Attack(monster, player);
                } else {
                    // monster attacks first
                    Attack(monster, player);
                    // then player gets to respond
                    System.out.println("What would you like to do?");
                    Scanner scan = new Scanner(System.in);
                    String input = scan.nextLine();
                    switch (input.toLowerCase()) {
                    case "attack":
                    case "a":
                        // Player attack
                        Attack(player, monster);
                        break;
                    case "leave":
                    case "l":
                        if (player.RollInitiative() > monster.RollInitiative()) {
                            System.out.println("You escaped!");
                            //TODO: player returns to previous room
                            inCombat = false;
                        } else {
                            System.out.println(monster.getName() + "prevents your escape!");
                        }
                    default:
                        System.out.println("You do not attack.");
                        break;
                    }
                }
            }
        }
        inCombat = false;
    }

    private void Attack(CharacterController attacker, CharacterController target) {
        if (attacker.getAttackRoll() > target.getArmorClass()) {
            int damage = attacker.getDamageRoll();
            target.setHealth(target.getHealth() - damage);
            System.out.println(attacker.getName() + " did " + damage + "damage to " + target.getName());
            inCombat = true;
        }
        if (target.getHealth() <= 0) {
            System.out.println(attacker.getName() + " defeated " + target.getName() + "!");
            //TODO: if target is a monster the monster needs to be removed form the current room.
            inCombat = false;
        } else {
            System.out.println(attacker.getName() + "missed!");
            inCombat = true;
        }

    }
    // TODO: Create/balance enemy stats
    // Boss/Knight > Spider > > Mimic > Slime > Goblin
    // General range to scale numbers off of once playtested
    // Very Low - 1 - 3 
    // Low - 3 - 4
    // Medium 5
    // High 5 - 10
    // Goblin - low damage, very low health, medium armor
    // Slime - low damage, high health, very low armor
    // Mimic - medium damage, low health, high armor
    // Spider -  high damage, high health, very low armor
    // Boss -  medium damage, very high health, medium armor
    // Each has 1 low stat, weakness, except the boss

}