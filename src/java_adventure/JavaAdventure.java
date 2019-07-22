package java_adventure;

import java.io.IOException;

public class JavaAdventure {

    public static void main(String[] args) throws IOException, InterruptedException {
        GameManager gm = GameManager.getInstance();
        InputManager im = InputManager.getInstance();
        gm.setInputManagerInstance();
        im.Welcome();
        if (gm.beginQuest) {
            gm.CreateDungeon();
            im.setCurrentRoom(gm.dungeon.get(0));
            System.out.println(im.getCurrentRoom().toString(im.getCurrentRoom().getHasMonster()));// first draw room
        }
        gm.CreateDungeon();
        im.setCurrentRoom(gm.dungeon.get(0));
        while (gm.player.getHealth() > 0) {
            im.VerifyInput(im.getCurrentRoom());
        }
    }

}
