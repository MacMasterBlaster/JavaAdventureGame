package java_adventure;

import java.util.Scanner;

public class TurnCombatTest {

    public static void main(String[] args) {

        //TODO Implement player & enemy attack
        boolean combat = false;
        int enemyHealth;
        enemyHealth = 1;
        if (enemyHealth > 0) {
            combat = true;
        }

        System.out.println("Entered combat with " + "-enemyname-" + "!");
        while (combat == true) {

            {

                System.out.println("What would you like to do?");
                Scanner scan = new Scanner(System.in);
                String input = scan.nextLine();
                System.out.println("Enter player attack damage");
                int playerAttack = scan.nextInt();
                System.out.println("Enter enemy attack damage");
                int enemyAttack = scan.nextInt();
                System.out.println("Enter player armor");
                int playerArmor = scan.nextInt();
                System.out.println("Enter enemy armor");
                int enemyArmor = scan.nextInt();
                System.out.println("Enter player health");
                int playerHealth = scan.nextInt();
                System.out.println("Enter enemy health");
                enemyHealth = scan.nextInt();

                switch (input.toLowerCase()) {
                    case "attack":
                    case "a":
                        if (playerAttack >= enemyArmor) {
                            enemyHealth = enemyHealth - playerAttack;
                            System.out.println("You did " + (playerAttack)
                                    + " damage!");

                            if (enemyHealth <= 0) {
                                System.out.println("You defeated the " + "-enemyname-" + "!");
                                combat = false;
                                break;
                            }
                        }
                        if (playerAttack < enemyArmor) {
                            System.out.println("You missed!");
                        }

                        System.out.println("The" + "-enemyname-" + "attacked!");

                        if (enemyAttack >= playerArmor) {

                            playerHealth = playerHealth - enemyAttack;
                            System.out.println("You took " + enemyAttack + " damage!");

                            if (playerHealth <= 0) {
                                System.out.println("You were defeated!");
                                combat = false;
                            }
                        }
                        if (enemyAttack < playerArmor) {
                            System.out.println("The" + "-enemyname-" + "missed!");
                        }
                        break;
                    case "leave":
                    case "l":
                        System.out.println("Escaped");
                        break;
                    default:
                        System.out.println("You do not attack.");
                        System.out.println("The" + "-enemyname-" + " + attacked!");
                        if (enemyAttack >= playerArmor) {

                            playerHealth = playerHealth - enemyAttack;
                            System.out.println("You took " + enemyAttack + " damage!");

                            if (playerHealth <= 0) {
                                System.out.println("You were defeated!");
                                combat = false;
                            }

                        }
                        if (enemyAttack < playerArmor) {
                            System.out.println("The" + "-enemyname-" + "missed!");
                        }
                        break;

                    //armour class, if attack > armour, deal damage, if < 0 end, monster defeat
                    // monster = false, if no damage dealt = " you miss"
                }
            }
        }

    }
}
