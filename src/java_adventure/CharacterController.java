// *****************************************************
// InputManager.java

// A controller for all characters. Stores all values
// needed from the character throughout the game. Can
// be used for both player and non-player characters.
// *****************************************************
package java_adventure;

//enum charClass {wizard, warrior, god, goblin, rat}
public class CharacterController {
    private String name; // the name of the character
    private int health, maxHealth; // current health and max possible health
    private int armorClass; // the threshold for hitting with an attack
    private int damageDie, damageMod, attackMod; // die type rolled & modifiers added to character attacks
    private String charClass; // sets default values for maxHealth & damageMod
    private Dice d;
    
    public CharacterController() {
        name = "Nobody";
        charClass = "N/A";
        health = 10;
        maxHealth = 10;
        armorClass = 10;
        damageDie = 4;
        damageMod = 0;
        attackMod = 0;
    }

    public CharacterController(String newName, String newCharClass) {
        name = newName;
        charClass = newCharClass;
        health = 10;
        maxHealth = 10;
        armorClass = 10;
        damageDie = 4;
        damageMod = 0;
        attackMod = 0;
    }

    public int RollInitiative(){
        return d.RollInitiative(20, 0);
    }

    public int getAttackRoll() {
        return d.RollAttack(damageDie, attackMod);
    }

    public int getDamageRoll() {
        return d.RollDamage(damageDie, damageMod);
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int currentHealth) {
        health = currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int currentMaxHealth) {
        maxHealth = currentMaxHealth;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int newArmorClass) {
        armorClass = newArmorClass;
    }

    public int getDamageDie() {
        return damageDie;
    }

    public void setDamageDie(int newDamageDie) {
        damageDie = newDamageDie;
    }

    public int getDamageMod() {
        return damageMod;
    }

    public void setDamageMod(int newDamageMod) {
        damageMod = newDamageMod;
    }

    public int getAttackMod() {
        return attackMod;
    }

    public void setAttackMod(int newAttackMod) {
        attackMod = newAttackMod;
    }

    public String getCharClass() {
        return charClass;
    }

    public void setCharClass(String newCharClass) {
        charClass = newCharClass;
    }

    public String toString() {
        return name + ":\n\tClass: " + charClass + "\n\tHealth: " + health + "/" + maxHealth + "\n\tArmor Class: "
                + armorClass + "\n\tDamage: 1D" + damageDie + " + " + damageMod + "\n\tAttack: 1D20" + " + "
                + attackMod;
    }
}