// *****************************************************
// InputManager.java

// A controller for all characters. Stores all values
// needed from the character throughout the game. Can
// be used for both player and non-player characters.
// *****************************************************

public class CharacterController{
    public static String name; // the name of the character
    public static int health, maxHealth; // current health and max possible health
    public static int mana, maxMana; // current mana and max possible mana.
    public static int armorClass; // the threshold for hitting with an attack
    public static int damageDie, damageMod, attackMod; // die type rolled & modifiers added to character attacks
    public static int xp; // character exp value or players current exp amount
    public static String charClass; // sets default values for maxHealth, maxMana, & damageMod

}