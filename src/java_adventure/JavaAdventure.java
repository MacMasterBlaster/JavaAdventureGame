package java_adventure;

public class JavaAdventure {

    public static void main(String[] args) {
        GameManager gm = new GameManager();
        InputManager im = new InputManager(gm);
        im.Welcome();
        gm.RoomCreationTest();
        im.setCurrentRoom(gm.dungeon.get(0));
        while (gm.player.getHealth() > 0) {
            im.VerifyInput(im.getCurrentRoom());
        }
        im.GameOver();
    }

}
