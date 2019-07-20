
// *****************************************************
// Die.java
//
// A controller for "rolling" dice for attacks and for damage.
// Will also be used for all random number generation.
// *****************************************************
package java_adventure;

//import java.util.Scanner;
import java.util.Random;;

public class Dice {
    static Random rand = new Random();

    public int RollDamage(int die, int damageMod) {
        int i = rand.nextInt(die + 1);
        while (i == 0) {
            i = rand.nextInt(die + 1);
        }
        return i + damageMod;
    }

    public int RollAttack(int die, int attackMod) {
        int i = rand.nextInt(die + 1);
        while (i == 0) {
            i = rand.nextInt(die + 1);
        }
        return i + attackMod;
    }
    public int RollInitiative(int die, int mod) {
        int i = rand.nextInt(die + 1);
        while (i == 0) {
            i = rand.nextInt(die + 1);
        }
        return i + mod;
    }
    /*
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Test RollAttack Method:");
        System.out.println("Attack mod value:");
        int attackMod = scan.nextInt();
        System.out.println("Attack Roll: " + RollAttack(20, attackMod) + "\n");

        System.out.println("Test RollDamage Method:");
        System.out.println("Damage die type:");
        int damageDie = scan.nextInt();
        System.out.println("DamageMod value:");
        int damageMod = scan.nextInt();
        System.out.println("Damage Roll: " + RollDamage(damageDie, damageMod));
        scan.close();
    }
    */
}