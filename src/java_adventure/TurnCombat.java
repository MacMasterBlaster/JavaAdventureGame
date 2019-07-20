package java_adventure;

import java.util.Scanner;

public class TurnCombat {

    public static void main(String[] args) {

        //TODO Implement player & enemy attack
        boolean combat = true;

        System.out.println("Entered combat with " + "enemyname" + "!");
        while (combat == true) {
            {
                
            System.out.println("What would you like to do?");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            switch (input.toLowerCase()) {
            case "attack":
            case "a":            
                //Player attack
                if (player.attack > monster.armor) {
                System.out.println("You did " + (monster.health - player.attack)
                + "damage!");
                
                if (monster.health <= 0) {
                    System.out.println("You defeated the " + "enemyname" + "!");
                    combat = false;
                }
                else if (player.attack < monster.armor) {
                System.out.println("You missed!"); 
                }
                else{
                    System.out.println("You can't do that. Try attacking.");
                }
                break;
               
            }
               
               
            
            case "leave":
            case "l":
                    System.out.println("Escaped!");   
                    combat = false;
            default:                
                System.out.println("You do not attack.");
                break;
            }
           
            //monster attack
            if (monster.attack > player.armor){
            
             
              player.health = player.health - monster.attack;
              System.out.println("You took " + (player.health - monster.attack) + " damage!");
              
              if (player.health <= 0) {
                System.out.println("You were defeated!");
                 combat = false;
            }
                     
            }
              else if (monster.attack < player.armor) {
                      System.out.println ("The" + "enemyname" + "missed!");
                      }
            }
                 
        }
          combat = false;
          //armour class, if attack > armour, deal damage, if < 0 end, monster defeat
          // monster = false, if no damage dealt = " you miss"
}
}