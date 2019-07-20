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
        
        String M1, M2, M3, M4, M5;
        
        M1 = Monster1;
        M2 = Monster2;
        M3 = Monster3;
        M4 = Monster4;
        M5 = Monster5;
        
        
        
        System.out.println("******************" + "************" + "******************" 
                          +"\t You enter a new room. in front of you is an" 
                        +"\n/                                              \\"
                          +"\t empty room with no doors."
                        +"\n\\                                              /"
                          +"\t There are 4 doors to The NORTH, SOUTH, EAST, and WEST."
                        +"\n/                                              \\"
                          +"\t YOU ARE TRAPPED FOREVER"
                        +"\n\\                                              /"
                        +"\t text."
                        +"\n/                                              \\"
                          +"\t text."
                        +"\n\\                    " + M1 + "                    /"
                          +"\t text."
                        +"\n" + "/" + "                    " + M2 + "                    " + "\\"
                          +"\t text."
                        +"\n" + "\\" + "                    " + M3 + "                    " + "/"
                          +"\t text"
                        +"\n" + "/" + "                    " + M4 + "                    " + "\\"
                          +"\t text."
                        +"\n" + "\\" + "                    " + M5 + "                    " + "/"
                          +"\t text"
                        +"\n/                                              \\"
                          +"\t text."
                        +"\n\\                                              /"
                          +"\t text"
                        +"\n/                                              \\"
                          +"\t text."
                        +"\n\\                                              /"
                          +"\tEnter NORTH, EAST, SOUTH, or WEST to go through that door. "
                         +"\n/                                              \\"
                          +"\tEnter STATUS to check your character's status, leave to run away, "
                        +"\n\\                                              /"
                          +"\tor FIGHT to fight: "
                        + "\n******************" + "************" + "******************"
                          +"\t text"
        //+ "\nEnter NORTH, EAST, SOUTH, or WEST to go through that door. "
        //+ "Enter STATUS to check your character's status, leave to run away, "
        //+ "\nor FIGHT to fight. "
        //+ "choose what to do next based on said prompts"
        );
        
    }
    
}
