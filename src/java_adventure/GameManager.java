// *****************************************************
// GameManager.java

// Manages game states, player and enemy creation, and 
// level position.
// *****************************************************
package java_adventure;

import java.util.ArrayList;

public class GameManager {
    InputManager im;
    boolean inCombat = false;
    ArrayList<Room> dungeon = new ArrayList<Room>();
    CharacterController m_goblin = new CharacterController();
    CharacterController m_slime1 = new CharacterController();
    CharacterController m_slime2 = new CharacterController();
    CharacterController m_mimic = new CharacterController();
    CharacterController m_spider = new CharacterController();
    CharacterController m_boss = new CharacterController();
    
    public CharacterController player = new CharacterController("Nobody", "None");

    public void setInputManager(InputManager _im){
        im = _im;
    }

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
    public void MakeGoblin(CharacterController newCharacter) {
        newCharacter.setHealth(10);
        newCharacter.setMaxHealth(10);
        newCharacter.setArmorClass(4);
        newCharacter.setDamageDie(1);
        newCharacter.setDamageMod(2);
        newCharacter.setAttackMod(2);
        newCharacter.setCharClass("Goblin");
        newCharacter.setName("Goblin");
    }

    public void MakeSlime(CharacterController newCharacter) {
        newCharacter.setHealth(25);
        newCharacter.setMaxHealth(25);
        newCharacter.setArmorClass(5);
        newCharacter.setDamageDie(1);
        newCharacter.setDamageMod(1);
        newCharacter.setAttackMod(1);
        newCharacter.setCharClass("Slime");
        newCharacter.setName("Slime");
    }

    public void MakeMimic(CharacterController newCharacter) {
        newCharacter.setHealth(15);
        newCharacter.setMaxHealth(15);
        newCharacter.setArmorClass(10);
        newCharacter.setDamageDie(5);
        newCharacter.setDamageMod(2);
        newCharacter.setAttackMod(4);
        newCharacter.setCharClass("Mimic");
        newCharacter.setName("Mimic");
    }

    public void MakeSpider(CharacterController newCharacter) {
        newCharacter.setHealth(25);
        newCharacter.setMaxHealth(25);
        newCharacter.setArmorClass(20);
        newCharacter.setDamageDie(5);
        newCharacter.setDamageMod(4);
        newCharacter.setAttackMod(5);
        newCharacter.setCharClass("Spider");
        newCharacter.setName("Spider");
    }

    public void MakeKnight(CharacterController newCharacter) {
        newCharacter.setHealth(40);
        newCharacter.setMaxHealth(40);
        newCharacter.setArmorClass(10);
        newCharacter.setDamageDie(7);
        newCharacter.setDamageMod(5);
        newCharacter.setAttackMod(6);
        newCharacter.setCharClass("Knight");
        newCharacter.setName("Black Knight Javalang");
    }
    // endregion

    public void CreateDungeon() {
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
        //room names for debugging
        start.setName("start");
        moveAssit.setName("moveAssit");
        fight.setName("fight");
        empty1.setName("empty1");
        empty2.setName("empty2");
        empty3.setName("empty3");
        slime1.setName("slime1");
        slime2.setName("slime2");
        chest1.setName("chest1");
        chest2.setName("chest2");
        mimic.setName("mimic");
        spider.setName("spider");
        empty4.setName("empty4");
        boss.setName("boss");
        treasure.setName("treasure");
        end.setName("end");
        // Make Monsters
        MakeGoblin(m_goblin);
        MakeSlime(m_slime1);
        MakeSlime(m_slime2);
        MakeMimic(m_mimic);
        MakeSpider(m_spider);
        MakeKnight(m_boss);
        // Set all room linkages
        start.setwDoor(moveAssit);
        start.setRoomImage(null);

        moveAssit.setExits(fight, null, null, start);
        moveAssit.setRoomImage(null);

        fight.setExits(empty1, null, moveAssit, null);
        fight.setMonster(m_goblin);
        fight.setHasMonster(true);
        fight.setRoomImage(null);

        empty1.setExits(empty3, empty2, fight, null);
        empty1.setRoomImage(null);

        empty2.setExits(slime1, slime2, null, empty1);
        empty2.setRoomImage(null);

        empty3.setExits(null, slime1, empty1, null);
        empty3.setRoomImage(null);

        slime1.setExits(null, chest2, empty2, empty3);
        slime1.setMonster(m_slime1);
        slime1.setHasMonster(true);
        slime1.setRoomImage(null);

        slime2.setExits(null, null, mimic, empty2);
        slime2.setMonster(m_slime2);
        slime2.setHasMonster(true);
        slime2.setRoomImage(null);

        chest1.setExits(null, mimic, null, null);
        chest1.setRoomImage(null);

        chest2.setExits(null, slime1, null, null);
        chest2.setRoomImage(null);

        mimic.setExits(slime2, null, spider, null);
        mimic.setMonster(m_mimic);
        mimic.setHasMonster(true);
        mimic.setRoomImage(null);

        spider.setExits(mimic, empty4, null, null);
        spider.setMonster(m_spider);
        spider.setHasMonster(true);
        spider.setRoomImage(null);

        empty4.setExits(boss, null, null, empty4);
        empty4.setRoomImage(null);

        boss.setExits(treasure, null, empty4, null);
        boss.setMonster(m_boss);
        boss.setHasMonster(true);
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
    // Spider - high damage, high health, very low armor
    // Boss - medium damage, very high health, medium armor
    // Each has 1 low stat, weakness, except the boss
}