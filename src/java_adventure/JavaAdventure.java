package java_adventure;

public class JavaAdventure {
    public static void main(String[] args) {
        InputManager im = new InputManager();
        GameManager gm = new GameManager();
        CharacterController player = new CharacterController("Mac", "Wizard");
        gm.MakeGod(player, player.getName());
        gm.RoomCreationTest();
        im.setCurrentRoom(gm.dungeon.get(0));
        while (player.getHealth() > 0) {
            im.VerifyInput(im.getCurrentRoom());
        }
    }

}
