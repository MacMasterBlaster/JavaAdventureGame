// *****************************************************
// GameManager.java

// Manages game states, player and enemy creation, and 
// level position.
// *****************************************************
package java_adventure;

public class GameManager{

    public static void main(String[] args){
        CharacterController player = new CharacterController("Mac", "Wizard");
        MakeGod(player, player.getName());
        System.out.println(player.toString());
    }

    public static void MakeWizard(CharacterController newCharacter, String name) {
        newCharacter.setHealth(15);
        newCharacter.setMaxHealth(15);
        newCharacter.setArmorClass(8);
        newCharacter.setDamageDie(6);
        newCharacter.setDamageMod(5);
        newCharacter.setAttackMod(5);
        newCharacter.setCharClass("Wizard");
    }

    public static void MakeWarrior(CharacterController newCharacter, String name) {
        newCharacter.setHealth(30);
        newCharacter.setMaxHealth(30);
        newCharacter.setArmorClass(15);
        newCharacter.setDamageDie(10);
        newCharacter.setDamageMod(2);
        newCharacter.setAttackMod(6);
        newCharacter.setCharClass("Warrior");
    }

    // For play testing only!
    public static void MakeGod(CharacterController newCharacter, String name) {
        newCharacter.setHealth(1000);
        newCharacter.setMaxHealth(1000);
        newCharacter.setArmorClass(100);
        newCharacter.setDamageDie(100);
        newCharacter.setDamageMod(100);
        newCharacter.setAttackMod(100);
        newCharacter.setCharClass("God");
    }
   public static void MakeGoblin(CharacterController newCharacter, String name) {
        newCharacter.setHealth(10);
        newCharacter.setMaxHealth(10);
        newCharacter.setArmorClass(3);
        newCharacter.setDamageDie(5);
        newCharacter.setDamageMod(2);
        newCharacter.setAttackMod(3);
        newCharacter.setCharClass("Goblin");
    }
   
    public static void MakeSlime(CharacterController newCharacter, String name) {
        newCharacter.setHealth(25);
        newCharacter.setMaxHealth(25);
        newCharacter.setArmorClass(20);
        newCharacter.setDamageDie(4);
        newCharacter.setDamageMod(3);
        newCharacter.setAttackMod(4);
        newCharacter.setCharClass("Slime");
    }
   
     public static void MakeMimic(CharacterController newCharacter, String name) {
        newCharacter.setHealth(18);
        newCharacter.setMaxHealth(18);
        newCharacter.setArmorClass(10);
        newCharacter.setDamageDie(10);
        newCharacter.setDamageMod(1);
        newCharacter.setAttackMod(10);
        newCharacter.setCharClass("Mimic");
    }
     public static void MakeSpider(CharacterController newCharacter, String name) {
        newCharacter.setHealth(25);
        newCharacter.setMaxHealth(25);
        newCharacter.setArmorClass(20);
        newCharacter.setDamageDie(0);
        newCharacter.setDamageMod(0);
        newCharacter.setAttackMod(0);
        newCharacter.setCharClass("Spider");
    }
   
     public static void MakeKnight(CharacterController newCharacter, String name) {
        newCharacter.setHealth(40);
        newCharacter.setMaxHealth(40);
        newCharacter.setArmorClass(22);
        newCharacter.setDamageDie(12);
        newCharacter.setDamageMod(6);
        newCharacter.setAttackMod(8);
        newCharacter.setCharClass("Knight");
    }
            
            
    //TODO: Create/balance enemy stats
    //Boss/Knight > Spider > > Mimic > Slime > Goblin
           
}