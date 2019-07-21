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
    String H1, H2, H3, H4, H5;
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
    H1 = "     " + e1;
    H2 = "  O  " + e2;
    H3 = " /T\\_" + e3;
    H4 = " / \\ " + e4;
    H5 = "-   -" + e5;
    
    // test display
    
    System.out.println( H1 + "\n" + H2 + "\n" + H3 + "\n" + H4 + "\n" + H5);
    
    
    }
    
    
            
    
    
    
    
    
}
