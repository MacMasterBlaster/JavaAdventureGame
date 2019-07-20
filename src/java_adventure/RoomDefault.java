// RoomDefault.java
//
// Author: Noah Wagstaff
// create room outline for quick reference when creating all the rooms
package java_adventure;

public class RoomDefault {
    
    public static void main (String[] args) {
        
        String Monster1 = "MMMMMM";
        String Monster2 = "MMMMMM";
        String Monster3 = "MMMMMM";
        String Monster4 = "MMMMMM";
        String Monster5 = "MMMMMM";
        String BlankM = "      ";
        
        String H1, H2, H3, H4, H5;
        
        H1 = Monster1;
        H2 = Monster2;
        H3 = Monster3;
        H4 = Monster4;
        H5 = Monster5;
        
        // create prompt strings to be inserted into room string
        String P1 = "Enter north(n), east(e), south(s), or west(w) ";
        String P2 = "to go through that door. Enter STATUS to check ";
        String P3 = "your character's status, leave to run away, or ";
        String P4 = "FIGHT to fight: ";
        String P5 = " ";
               
        
        
        
        System.out.println("   ******************" + "************" + "******************" 
                          +"\tYou enter a new room. in front of you is an" 
                        +"\n   |                                              |"
                          +"\tempty room with no doors."
                        +"\n   |                                              |"
                          +"\tThere are 4 doors to The NORTH, SOUTH, EAST, and WEST."
                        +"\n   |                                              |"
                          +"\tYOU ARE TRAPPED FOREVER"
                        +"\n   |                                              |"
                        +"\n   |                                              |"
                        +"\n   |                    " + H1 + "                    |"
                        +"\n   " + "|" + "                    " + H2 + "                    " + "|"
                        +"\n   " + "|" + "                    " + H3 + "                    " + "|"
                        +"\n   " + "|" + "                    " + H4 + "                    " + "|"
                        +"\n   " + "|" + "                    " + H5 + "                    " + "|"                          
                        +"\n   |                                              |"
                        +"\n   |                                              |"

                        +"\n   |                                              |"
                          +"\t" + P1
                        +"\n   |                                              |"
                          +"\t" + P2
                         +"\n   |                                              |"
                          +"\t" + P3
                        +"\n   |                                              |"
                          +"\t" + P4
                        + "\n   ******************" + "************" + "******************"
                          +"\t" + P5);
        
    }
    
}
