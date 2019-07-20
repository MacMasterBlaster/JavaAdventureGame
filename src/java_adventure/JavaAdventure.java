package java_adventure;

public class JavaAdventure {

    public static void main(String[] args) {
        GameManager gm = new GameManager();
        InputManager im = new InputManager(gm);
        im.Welcome();
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
        gm.RoomCreationTest();
        im.setCurrentRoom(gm.dungeon.get(0));
        while (gm.player.getHealth() > 0) {
            im.VerifyInput(im.getCurrentRoom());
        }
        im.GameOver();
    }

}
