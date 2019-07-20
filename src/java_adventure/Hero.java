// Hero.java
//
// Author: Noah Wagstaff
// Defines the hero sprite
package java_adventure;

import java.util.Scanner;



public class Hero {
     
public String HeroSprite(){        
         // initialize and define strings to represent the hero sprite
    String F1 = "|";
    String F2 = "|";
    String F3 = "D";
    String blank = " ";
    String W1 = "ø";
    String W2 = "¥";
    String W3 = "|";
    String W4 = "¿";
    String e1 = blank, e2 = blank, e3 = blank, e4 = blank, e5 = blank;
    String h1, h2, h3, h4, h5;
    switch (charClass)
    {
        case "WARRIOR":
            e1 = F1;
            e2 = F2;
            e3 = F3;
            break;
        case "WIZARD":
            e1 = W1;
            e2 = W2;
            e3 = W3;
            e4 = W4;
            break;
        default:
            break;
    }
    
    
    // Define hero avatar lines
    h1 = "     " + e1;
    h2 = "  O  " + e2;
    h3 = " /T\\_" + e3;
    h4 = " / \\ " + e4;
    h5 = "-   -" + e5;
    
    // test display
    
    System.out.println( h1 + "\n" + h2 + "\n" + h3 + "\n" + h4 + "\n" + h5);
    
    
    }
    
    
            
    
    
    
    
    
}
