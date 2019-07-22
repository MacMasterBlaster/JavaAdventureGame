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
    private int damageDie, damageMod, attackMod, initMod; // die type rolled & modifiers added to character attacks
    private String charClass; // sets default values for maxHealth & damageMod
    private Dice d = new Dice();
    
    String F1 = "|";
    String F2 = "|";
    String F3 = "D";
    String blank = " ";
    String W1 = "ø";
    String W2 = "¥";
    String W3 = "|";
    String W4 = "¿";
    String e1 = blank, e2 = blank, e3 = blank, e4 = blank, e5 = blank;
    String H1, H2, H3, H4, H5;
    
    public CharacterController() {
        name = "Nobody";
        charClass = "N/A";
        health = 10;
        maxHealth = 10;
        armorClass = 10;
        damageDie = 4;
        damageMod = 0;
        attackMod = 0;
        initMod = 0;
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

    //set hero sprite lines
    public void CharacterSprite() {
        switch (charClass.toLowerCase())
        {
            case "warrior":
                e1 = F1;
                e2 = F2;
                e3 = F3;
                break;
            case "wizard":
            case "god":
                e1 = W1;
                e2 = W2;
                e3 = W3;
                e4 = W4;
                break;
            default:
                break;
        }
        H1 = "     " + e1;
        H2 = "  O  " + e2;
        H3 = " /T\\_" + e3;
        H4 = " / \\ " + e4;
        H5 = "-   -" + e5;
    }

    public int RollInitiative(){
        return d.RollInitiative(20, initMod);
    }

    public int getInitMod() {
        return initMod;
    }
    
    public void setInitMod(int _initMod) {
        initMod = _initMod;
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
        return " " + name + ":\n   " + H1 + "\tClass: " + charClass + "\n   " + H2 + "\tHealth: " + health + "/" + maxHealth + "\n   " + H3 + "\tArmor Class: "
                + armorClass + "\n   " + H4 + "\tDamage: 1D" + damageDie + " + " + damageMod + "\n   " + H5 + "\tAttack: 1D20" + " + "
                + attackMod;
    }
}