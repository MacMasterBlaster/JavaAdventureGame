// *****************************************************
// Die.java
//
// A controller for "rolling" dice for attacks and for damage.
// Will also be used for all random number generation.
// *****************************************************

import java.util.*;

public class Dice{
    Random rand = new Random();

    public int RollDamage(int die, int damageMod){
        int i = rand.nextInt(die + 1);
        while (i == 0){
            i = rand.nextInt(die + 1);
        }
        return i + damageMod;
    }
    
    public int RollAttack(int die, int attackMod){
        int i = rand.nextInt(die + 1);
        while (i == 0){
            i = rand.nextInt(die + 1);
        }
        return i + attackMod;
    }
}