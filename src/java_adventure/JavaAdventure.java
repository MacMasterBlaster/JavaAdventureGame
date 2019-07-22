package java_adventure;

import java.io.IOException;

public class JavaAdventure {

    public static void main (String[] args)throws IOException, InterruptedException{
        GameManager gm = GameManager.getInstance();
        InputManager im = new InputManager(gm);
        gm.setInputManager(im);
        im.Welcome();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // clears the console window.
        gm.CreateDungeon();
        im.setCurrentRoom(gm.dungeon.get(0));
        while (gm.player.getHealth() > 0) {
            im.VerifyInput(im.getCurrentRoom());
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();// clears the console window.
        }
        im.GameOver();
    }

}
