package java_adventure;

import java.io.IOException;

public class JavaAdventure {

    public static void main (String[] args)throws IOException, InterruptedException{
        GameManager gm = new GameManager();
        InputManager im = new InputManager(gm);
        im.Welcome();
<<<<<<< HEAD
        final String ANSI_CLS = "\u001b[2J";
        final String ANSI_HOME = "\u001b[H";
        System.out.print(ANSI_CLS + ANSI_HOME);
        System.out.flush();
=======
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor(); // clears the console window.
>>>>>>> 783fd95789f2d4ecafd2c991467a9b6b194509e9
        gm.RoomCreationTest();
        im.setCurrentRoom(gm.dungeon.get(0));
        while (gm.player.getHealth() > 0) {
            im.VerifyInput(im.getCurrentRoom());
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();// clears the console window.
        }
        im.GameOver();
    }

}
