// RoomImage.java
//
// Author: Noah Wagstaff
// a reference for all room images
package java_adventure;

public class RoomImage {

  public String defaultRoom() {
    return "   ******************" + "************" + "******************"
        + "\tYou enter a new room. in front of you is an" + "\n   |                                              |"
        + "\tempty room with no doors." + "\n   |                                              |"
        + "\tThere are 4 doors to The NORTH, SOUTH, EAST, and WEST."
        + "\n   |                                              |" + "\tYOU ARE TRAPPED FOREVER"
        + "\n   |                                              |"
        + "\n   |                                              |" + "\n   |                    " + H1
        + "                    |" + "\n   " + "|" + "                    " + H2 + "                    " + "|" + "\n   "
        + "|" + "                    " + H3 + "                    " + "|" + "\n   " + "|" + "                    " + H4
        + "                    " + "|" + "\n   " + "|" + "                    " + H5 + "                    " + "|"
        + "\n   |                                              |"
        + "\n   |                                              |"

        + "\n   |                                              |" + "\t" + P1
        + "\n   |                                              |" + "\t" + P2
        + "\n   |                                              |" + "\t" + P3
        + "\n   |                                              |" + "\t" + P4 + "\n   ******************"
        + "************" + "******************" + "\t" + P5;

  }

  public String startRoom() {
    return null;
  }
  public String hall() {
      return "\t\t     \\          /\t\t" 
                          +"\tWelcome to the entrance of dungeon Javalang. " 
                        +"\n\t\t     /          \\\t\t"
                          +"\tInside are dangers greater that what you are used"
                        +"\n\t\t     \\          /\t\t"
                          +"\tto but also great rewards. This area over here "
                        +"\n\t\t     /          \\\t\t"
                          +"\tYtell you what the area looks like and give you "
                        +"\n\t\t     \\          /\t\t"
                        +"\tideas if what you can do in all caps. Try typing in"
                        +"\n\t\t     /          \\\t\t"
                          +"\tSTATUS. You will also be using the cardinal"
                        +"\n\t\t     \\  " + H1 + "  /\t\t"
                          +"\tdirections to move. you can type in the whole"
                        +"\n\t\t     /  "  + H2 + "  \\\t\t"
                          +"\tdirection or the first letter and it will still"
                        +"\n\t\t     \\  " + H3 + "  /\t\t"
                          +"\twork. But we will leave a full list at the bottom"
                        +"\n\t\t     /  " + H4 + "  \\\t\t"
                          +"\tfor you just in case."
                        +"\n\t\t     \\  " + H5 + "  /\t\t"
                          +"\tType NORTH or N to move forward. "
                        +"\n\t\t     /          \\\t\t"
                        +"\n\t\t     \\          /\t\t"
                        +"\n\t\t     /          \\\t\t"
                          +"\t" + P1
                        +"\n\t\t     \\          /\t\t"
                          +"\t" + P2
                         +"\n\t\t     /          \\\t\t"
                          +"\t" + P3
                        +"\n\t\t     \\          /\t\t"
                          +"\t" + P4
                        + "\n\t\t     /          \\\t\t"
                          +"\t" + P5;
  }
  public String start() {
      return "   ************************************************" 
                          +"\tYou enter the Javalang dungeon. The entrance " 
                        +"\n   |                                              |"
                          +"\tcrumbled soon after you arrived and there's no"
                        +"\n   |                                              |"
                          +"\tleaving that way anymore. Let's hope for your "
                        +"\n   |                                              |"
                          +"\tsake there is another way out. There is only one "
                        +"\n   |                                              |"
                        +"\tdoor to the WEST. So you should go that way. "
                        +"\n   |                                              |"
                        +"\n   |                    " + H1 + "                    |"
                        +"\n                        " + H2 + "                    |"
                        +"\n                        " + H3 + "                    |"
                        +"\n                        " + H4 + "                    |"
                        +"\n                        " + H5 + "                    |"
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
                        + "\n   ************************************************"
                          +"\t" + P5;
  }
  public String moveAssit(){
      return "   ******************" + "************" + "******************" 
                          +"\tYou enter a new room. There is nothing in it but" 
                        +"\n   /                                              \\"
                          +"\tyou. There are 2 doors to the North, and EAST."
                        +"\n   \\                                              /"
                          +"\tChoose a door to LEAVE."
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                    " + H1 + "                    /"
                        +"\n   /                    " + H2 + "                     "
                        +"\n   \\                    " + H3 + "                     "
                        +"\n   |                    " + H4 + "                     "
                        +"\n   |                    " + H5 + "                     "
                        +"\n   |                                              |"
                        +"\n   |                                              |"
                        +"\n   |                                              |"
                          +"\t" + P1
                        +"\n   |                                              |"
                          +"\t" + P2
                         +"\n  |                                              |"
                          +"\t" + P3
                        +"\n   |                                              |"
                          +"\t" + P4
                        + "\n   ************************************************"
                          +"\t" + P5;
  }
  public String fightWithEnemy(){
      return "   ******************            ******************" 
                          +"\tYou enter a new room. in front of you is " 
                        +"\n   /                                              \\"
                          +"\ta goblin. It looks easy enough. You think you "
                        +"\n   \\                                              /"
                          +"\tcould take it. Dou you LEAVE or do you FIGHT?"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                    |\\__/|                    /"
                        +"\n   /                    (O..O)                     "
                        +"\n   \\                    (>oo<)                     "
                        +"\n   /                     U--U                      "
                        +"\n   \\                                               "
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String fightWithoutEnemy() {
      return "   ******************            ******************" 
                          +"\tYou defeated the goblin in this room. You kind of " 
                        +"\n   /                                              \\"
                          +"\tjust propped up its body against the wall not "
                        +"\n   \\                                              /"
                          +"\tknowing what else to do. You feel awkward about it."
                        +"\n   /                                              \\"
                          +"\tTime to press on! There are 3 doors that go NORTH,"
                        +"\n   \\                                              /"
                        +"\tEAST, and SOUTH"
                        +"\n   /                                              \\"
                          +"\tChoose a door to LEAVE."
                        +"\n   \\                    " + H1 + "                    /"
                        +"\n   /                    " + H2 + "                     "
                        +"\n   \\                    " + H3 + "                     "
                        +"\n   /                    " + H4 + "                     "
                        +"\n   \\                    " + H5 + "                     "
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String Chest1With() {
      return "   ************************************************" 
                          +"\tYou enter a new room. in front of you is an" 
                        +"\n   /                                              |"
                          +"\told looking treasure chest."
                        +"\n   \\                                              |"
                          +"\tDo you OPEN the chest or LEAVE?"
                        +"\n   /                                              |"
                        +"\n   \\                                              |"
                        +"\n   /                                              |"
                        +"\n   \\                   _______                    |"
                        +"\n                      [|-----|]                   |"
                        +"\n                      ||||£||||                   |"
                        +"\n                      |||||||||                   |"
                        +"\n                                                  |"
                        +"\n   /                                              |"
                        +"\n   \\                                              |"
                        +"\n   /                                              |"
                          +"\t" + P1
                        +"\n   \\                                              |"
                          +"\t" + P2
                         +"\n   /                                              |"
                          +"\t" + P3
                        +"\n   \\                                              |"
                          +"\t" + P4
                        + "\n   ************************************************"
                          +"\t" + P5;
  }
  public String chest1Without() {
      return "   ************************************************" 
                          +"\tThis room is now empty. There is only one door" 
                        +"\n   /                                              |"
                          +"\tto the WEST. Do you LEAVE?"
                        +"\n   \\                                              |"
                        +"\n   /                                              |"
                        +"\n   \\                                              |"
                        +"\n   /                                              |"
                        +"\n   \\                    " + H1 + "                    |"
                        +"\n                        " + H2 + "                    |"
                        +"\n                        " + H3 + "                    |"
                        +"\n                        " + H4 + "                    |"
                        +"\n                        " + H5 + "                    |"
                        +"\n   /                                              |"
                        +"\n   \\                                              |"
                        +"\n   /                                              |"
                          +"\t" + P1
                        +"\n   \\                                              |"
                          +"\t" + P2
                         +"\n   /                                              |"
                          +"\t" + P3
                        +"\n   \\                                              |"
                          +"\t" + P4
                        + "\n   ************************************************"
                          +"\t" + P5;
  }
  public String empty1() {
      return "   ******************            ******************" 
                          +"\tYou enter the next room. you stand in an empty " 
                        +"\n   |                                              |"
                          +"\troom. You feel kinda lonely."
                        +"\n   |                                              |"
                          +"\tThere are 3 doors to the NORTH, EAST, and SOUTH."
                        +"\n   |                                              |"
                          +"\tChoose a door to LEAVE."
                        +"\n   |                                              |"
                        +"\n   |                                              |"
                        +"\n   |                    " + H1 + "                    |"
                        +"\n   |                    " + H2 + "                     "
                        +"\n   |                    " + H3 + "                     "
                        +"\n   /                    " + H4 + "                     "
                        +"\n   \\                    " + H5 + "                     "
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "   \n   ******************            ******************"
                          +"\t" + P5;
  }
  public String empty2() {
      return "   ******************            ******************" 
                          +"\tYou enter the next room. You stand in an empty " 
                        +"\n   /                                              \\"
                          +"\troom. You feel kinda lonely"
                        +"\n   \\                                              /"
                          +"\tThere are 3 doors to the NORTH, EAST, and WEST."
                        +"\n   /                                              \\"
                          +"\tChoose a door to LEAVE."
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                    " + H1 + "                    /"
                        +"\n                        " + H2 + "                     "
                        +"\n                        " + H3 + "                     "
                        +"\n                        " + H4 + "                     "
                        +"\n                        " + H5 + "                     "
                        +"\n   |                                              \\"
                        +"\n   |                                              /"
                        +"\n   |                                              \\"
                          +"\t" + P1
                        +"\n   |                                              /"
                          +"\t" + P2
                         +"\n   |                                              \\"
                          +"\t" + P3
                        +"\n   |                                              /"
                          +"\t" + P4
                        + "\n   ************************************************"
                          +"\t" + P5;
  }
  public String empty3(){
      return "   ************************************************" 
                          +"\tYou enter the next room. You stand in an empty " 
                        +"\n   |                                              \\"
                          +"\troom. You feel kinda lonely."
                        +"\n   |                                              /"
                          +"\tThere are 2 doors to the EAST, and SOUTH."
                        +"\n   |                                              \\"
                          +"\tChoose a door to LEAVE."
                        +"\n   |                                              /"
                        +"\n   |                                              \\"
                        +"\n   |                    " + H1 + "                    /"
                        +"\n   |                    " + H2 + "                     " 
                        +"\n   |                    " + H3 + "                     "  
                        +"\n   |                    " + H4 + "                     " 
                        +"\n   |                    " + H5 + "                     " 
                        +"\n   |                                              \\"
                        +"\n   |                                              /"
                        +"\n   |                                              \\"
                          +"\t" + P1
                        +"\n   |                                              /"
                          +"\t" + P2
                         +"\n   |                                              \\"
                          +"\t" + P3
                        +"\n   |                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String slime1WithEnemy() {
      return "   ************************************************" 
                          +"\tYou enter a new room. in front of you is a" 
                        +"\n   /                                              \\"
                          +"\tgiant moving mass of what looks like jello."
                        +"\n   \\                                              /"
                          +"\tThis is a monster called a slime. "
                        +"\n   /                                              \\"
                          +"\tDo you FIGHT or do you LEAVE?"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                   ________                   /"
                        +"\n                      (      o )                   "
                        +"\n                     (__________)                  "
                        +"\n                                                   "
                        +"\n                                                   "
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String slime1WithoutEnemy() {
      return "   ************************************************" 
                          +"\tYou reduced the slime in this room to a puddle" 
                        +"\n   /                                              \\"
                          +"\tof goop on the floor. There are 3 doors "
                        +"\n   \\                                              /"
                          +"\tto the EAST, SOUTH, and WEST."
                        +"\n   /                                              \\"
                          +"\tChoose a door to LEAVE."
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                    " + H1 + "                    /"
                        +"\n                        " + H2 + "                     "
                        +"\n                        " + H3 + "                     "
                        +"\n                        " + H4 + "                     "
                        +"\n                        " + H5 + "                     "
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String slime2WithEnemy () {
      return "   ******************            ******************" 
                          +"\tYou enter a new room. in front of you is a" 
                        +"\n   /                                              \\"
                          +"\tgiant moving mass of what looks like jello."
                        +"\n   \\                                              /"
                          +"\tThis is a monster called a slime. "
                        +"\n   /                                              \\"
                          +"\tDo you FIGHT or do you LEAVE?"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                   ________                   /"
                        +"\n                      (      o )                  \\"
                        +"\n                     (__________)                 /"
                        +"\n                                                  \\"
                        +"\n                                                  /"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String slime2WithoutEnemy() {
      return "   ******************            ******************" 
                          +"\tYou reduced the slime in this room to a puddle" 
                        +"\n   /                                              \\"
                          +"\tof goop on the floor. There are 3 doors "
                        +"\n   \\                                              /"
                          +"\tto the NORTH EAST, and SOUTH."
                        +"\n   /                                              \\"
                          +"\tChoose a door to LEAVE."
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                    " + H1 + "                    /"
                        +"\n                        " + H2 + "                    \\"
                        +"\n                        " + H3 + "                    /"
                        +"\n                        " + H4 + "                    \\"
                        +"\n                        " + H5 + "                    /"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String chest2With() {
      return "   ************************************************" 
                          +"\tYou enter a new room. in front of you is an" 
                        +"\n   /                                              |"
                          +"\told looking treasure chest."
                        +"\n   \\                                              |"
                          +"\tDo you OPEN the chest or LEAVE?"
                        +"\n   /                                              |"
                        +"\n   \\                                              |"
                        +"\n   /                                              |"
                        +"\n   \\                   _______                    |"
                        +"\n                      [|-----|]                   |"
                        +"\n                      ||||£||||                   |"
                        +"\n                      |||||||||                   \\"
                        +"\n                                                  /"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                          +"\t text"
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String chest2Without() {
      return "   ************************************************" 
                          +"\tThis room is now empty. There is a door" 
                        +"\n   /                                              |"
                          +"\tto the WEST and a door to the EAST." 
                        +"\n   \\                                              |"
                          +"\tChoose a door to LEAVE."
                        +"\n   /                                              |"
                        +"\n   \\                                              |"
                        +"\n   /                                              |"
                        +"\n   \\                    " + H1 + "                    |"
                        +"\n                        " + H2 + "                    |"
                        +"\n                        " + H3 + "                    |"
                        +"\n                        " + H4 + "                    \\"
                        +"\n                        " + H5 + "                    /"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String mimicWithEnemy() {
      return "   ******************            ******************" 
                          +"\tYou enter a new room. in front of you is an" 
                        +"\n   /                                              \\"
                          +"\told looking treasure chest. But there's something"
                        +"\n   \\                                              /"
                          +"\toff about it. Do you OPEN the chest or LEAVE?"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                   _______                    /"
                        +"\n   /                  [|-----|]                   \\"
                        +"\n   \\                  |VVV£VVV|                   /"
                        +"\n   /                  |||||||||                   \\"
                        +"\n   \\                  |||||||||                   /"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t " + P5;
  }
  public String mimicWithoutEnemy() {
      return "   ******************            ******************" 
                          +"\tYou slew the mimic in the room. There is nothing " 
                        +"\n   /                                              \\"
                          +"\tleft but you now. There are two doors. "
                        +"\n   \\                                              /"
                          +"\tOne goes NORTH and one goes SOUTH."
                        +"\n   /                                              \\"
                          +"\tChoose a door to LEAVE."
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                    " + H1 + "                    /"
                        +"\n   /                    " + H2 + "                    \\"
                        +"\n   \\                    " + H3 + "                    /"
                        +"\n   /                    " + H4 + "                    \\"
                        +"\n   \\                    " + H5 + "                    /"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String spiderWithEnemy() {
      return "   ******************            ******************" 
                          +"\tYou enter a new room. in front of you is a" 
                        +"\n   /                                              \\"
                          +"\tgrotesqe monster with many eyes and legs."
                        +"\n   \\                                              /"
                          +"\tThe only thing you could possibly call it is a"
                        +"\n   /                                              \\"
                          +"\tgiant spider. Dou you LEAVE or do you FIGHT?"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\             _____  _______________           /"
                        +"\n   /            / * * \\/  _   _  _  _  \\           "
                        +"\n   \\            \\* * */\\_/___/___/___\\_/           "
                        +"\n   /             \\\"_\"/  / \\ / \\ / \\ / \\            "
                        +"\n   \\                                               "
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ************************************************"
                          +"\t" + P5;
  }
  public String spiderWithoutEnemy() {
      return "   ******************            ******************" 
                          +"\tYou defeated the giant spider in this room." 
                        +"\n   /                                              \\"
                          +"\tSpider bits lay everywhere. You don't know if"
                        +"\n   \\                                              /"
                          +"\tyou prefered if it were still together or like."
                        +"\n   /                                              \\"
                          +"\tBetter move on sooner rather than later."
                        +"\n   \\                                              /"
                        +"\tThere are 2 doors to the NORTH and EAST."
                        +"\n   /                                              \\"
                          +"\tChoose a door to LEAVE."
                        +"\n   \\                    " + H1 + "                    /"
                        +"\n   /                    " + H2 + "                     "
                        +"\n   \\                    " + H3 + "                     "
                        +"\n   /                    " + H4 + "                     "
                        +"\n   \\                    " + H5 + "                     "
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ************************************************"
                          +"\t" + P5;
  }
  public String empty4() {
      return "   ******************            ******************" 
                          +"\tYou enter the next room. You stand in an empty " 
                        +"\n   /                                              \\"
                          +"\troom. You feel relief to have a chance to rest."
                        +"\n   \\                                              /"
                          +"\tThere are 2 doors to the West, and NORTH."
                        +"\n   /                                              \\"
                          +"\tChoose a door to LEAVE."
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                        +"\n   \\                    " + H1 + "                    /"
                        +"\n                        " + H2 + "                    \\"
                        +"\n                        " + H3 + "                    /"
                        +"\n                        " + H4 + "                    |"
                        +"\n                        " + H5 + "                    |"
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
                        + "\n   ************************************************"
                          +"\t" + P5;
  }
  public String bossWithEnemy() {
      return "   ******************            ******************" 
                          +"\tYou enter a new room. in front of you is a" 
                        +"\n   /                                              \\"
                          +"\tfigure in a daunting set of armor holding a "
                        +"\n   \\                                              /"
                          +"\tlarge shield and a huge glowing sword."
                        +"\n   /                                              \\"
                          +"\t\"WHO DARES TRESSPASS IN MY DUNGEON!!!\""
                        +"\n   \\                                              /"
                        +"\tThe figure's voice echoes loudly all around you."
                        +"\n   /                                              \\"
                          +"\tIt is time for your deadliest FIGHT yet."
                        +"\n   \\                           {|}                /"
                        +"\n   /                     _|T|_ {|}                \\"
                        +"\n   \\                /{\\_/|THT|\\{|}                /"
                        +"\n   /                \\{/   VWV  \\T                 \\"
                        +"\n   \\                     _/ \\_                    /"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" + P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String BossWithoutEnemy() {
      return "   ******************            ******************" 
                          +"\tYou defeated the enemy and now stand alone in" 
                        +"\n   /                                              \\"
                          +"\tthe dungeon. The only sound you hear is your own"
                        +"\n   \\                                              /"
                          +"\tragged breathing and the drips of water on the"
                        +"\n   /                                              \\"
                          +"\tcave floor."
                        +"\n   \\                                              /"
                        +"\tThere is a door to the SOUTH and a door to the "
                        +"\n   /                                              \\"
                        +"\tNORTH"
                        +"\n   \\                    " + H1 + "                    /"
                        +"\n   /                    " + H2 + "                    \\"
                        +"\n   \\                    " + H3 + "                    /"
                        +"\n   /                    " + H4 + "                    \\"
                        +"\n   \\                    " + H5 + "                    /"
                        +"\n   /                                              \\"
                        +"\n   \\                                              /"
                        +"\n   /                                              \\"
                          +"\t" + P1
                        +"\n   \\                                              /"
                          +"\t" +P2
                         +"\n   /                                              \\"
                          +"\t" + P3
                        +"\n   \\                                              /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String treasure() {
      return "   ******************            ******************" 
                          +"\tIn front of you is a room filed with treasure" 
                        +"\n   /    [----]   [---]             _______        \\"
                          +"\tchests. And since you defeated the previous owner"
                        +"\n   \\    ||[]||   ||£||            [|-----|]       /"
                          +"\tthey all belong to you now. And what luck! there"
                        +"\n   /    ||||||   |||||            ||||£||||       \\"
                          +"\tis light streaming in from the far door!"
                        +"\n   \\   _______                    |||||||||       /"
                        +"\t text."
                        +"\n   /  [|-----|]   [---]                    {----} \\"
                          +"\t text."
                        +"\n   \\  |VVV£VVV|   ||£|| " + H1 + "             ||[]|| /"
                          +"\t text."
                        +"\n   /  |||||||||   ||||| " + H2 + "    [---]    |||||| \\"
                          +"\t text."
                        +"\n   \\  |||||||||         " + H3 + "    ||£||           /"
                          +"\t text"
                        +"\n   /             [---]  " + H4 + "    |||||  [----]   \\"
                          +"\t text."
                        +"\n   \\    [-----]  ||£||  " + H5 + "    |||||  ||[]||   /"
                        +"\n   /    |||£|||  |||||                   ||||||   \\"
                        +"\n   \\    |||||||                [---]     _______  /"
                        +"\n   /         [---]             ||£||    [|-----|] \\"
                          +"\t" + P1
                        +"\n   \\  [---]  ||£||             |||||    ||||£|||| /"
                          +"\t" + P2
                         +"\n   /  ||£||  |||||                      ||||||||| \\"
                          +"\t" + P3
                        +"\n   \\  |||||                                       /"
                          +"\t" + P4
                        + "\n   ******************            ******************"
                          +"\t" + P5;
  }
  public String end() {
      return "That's all folks!!" + "\n test";
  }
}