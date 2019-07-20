// *****************************************************
// GameManager.java

// Manages game states, player and enemy creation, and 
// level position.
// *****************************************************
package java_adventure;

import java.util.ArrayList;

public class GameManager {
    ArrayList<Room> dungeon = new ArrayList<Room>();
    CharacterController player = new CharacterController("Nobody", "None");

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
        newCharacter.setHealth(10);
        newCharacter.setMaxHealth(10);
        newCharacter.setArmorClass(3);
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
        moveAssit.setExits(fight, null, null, start);
        fight.setExits(empty1, null, moveAssit, null);
        fight.setHasEnemy(true);// this could be changed to a enemy object instead.
        empty1.setExits(empty3, empty2, fight, null);
        empty2.setExits(slime1, slime2, null, empty1);
        empty3.setExits(null, slime1, empty1, null);
        slime1.setExits(null, chest2, empty2, empty3);
        slime2.setExits(null, null, mimic, empty2);
        chest1.setExits(null, mimic, null, null);
        chest2.setExits(null, slime1, null, null);
        mimic.setExits(slime2, null, spider, null);
        spider.setExits(mimic, empty4, null, null);
        empty4.setExits(boss, null, null, empty4);
        boss.setExits(treasure, null, empty4, null);
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

    // TODO: Create/balance enemy stats
    // Boss/Knight > Spider > > Mimic > Slime > Goblin

}