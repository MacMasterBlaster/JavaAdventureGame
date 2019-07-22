package java_adventure;

import static java_adventure.GameManager.player;

import java.io.IOException;

public class JavaAdventure {

    public static void main (String[] args)throws IOException, InterruptedException{
        GameManager gm = GameManager.getInstance();
        InputManager im = InputManager.getInstance();
        gm.setInputManagerInstance();
        im.Welcome();
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // clears the console window.
        im.setCurrentRoom(gm.dungeon.get(0));
        while (player.getHealth() > 0) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();// clears the console window.
            im.VerifyInput(im.getCurrentRoom());
        }
    }

}
