package java_adventure;

import java.io.IOException;

public class JavaAdventure {

    public static void main (String[] args)throws IOException, InterruptedException{
        GameManager gm = new GameManager();
        InputManager im = new InputManager(gm);
        im.Welcome();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // clears the console window.
        gm.RoomCreationTest();
        im.setCurrentRoom(gm.dungeon.get(0));
        while (gm.player.getHealth() > 0) {
            im.VerifyInput(im.getCurrentRoom());
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();// clears the console window.
        }
        im.GameOver();
    }

}
