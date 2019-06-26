
// ***********************************************
// InputManager.java
// Name: Mac Orchard
//
// Manages all user input. Verifying input validity 
// and providing input hints as needed.
// ***********************************************

import java.util.Scanner;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class InputManager {

    public static String input;

    public static void main(String[] args) {
        // System.out.println(input);
        // System.out.print("length: " + input.length());
        VerifyInput();
    }

    public static void CollectInput() {
        Scanner scan = new Scanner(System.in);
        input = scan.nextLine();
        scan.close();
    }

    // public static void VerifyInput() {
    // Scanner scan = new Scanner(System.in);
    // String input = scan.nextLine();

    // if ("yes".equals(input)) {
    // System.out.println("Yea I programmed this right!");
    // } else {
    // System.out.println("Awww :(");
    // }
    // scan.close();
    // }
    public static void VerifyInput() {
        Scanner scan = new Scanner(System.in);
        boolean isValid = false;
        while (isValid == false) {
            String input = scan.nextLine();
            switch (input.toLowerCase()) {
            case "north": case "n":
                isValid = true;
                System.out.println("You move north");
                break;
            case "south": case "s":
                isValid = true;
                System.out.println("You move south");
                break;
            case "east": case "e":
                isValid = true;
                System.out.println("You move east");
                break;
            case "west": case "w":
                isValid = true;
                System.out.println("You move west");
                break;
            case "help": case "h":           
                isValid = false;
                System.out.println("Try typing in a direction or action you wish to attempt.");
                break;
            default:
                isValid = false;
                System.out.println("Sorry I don't understand. What do you want to do?");
                break;
            }
        }
        scan.close();
    }
}