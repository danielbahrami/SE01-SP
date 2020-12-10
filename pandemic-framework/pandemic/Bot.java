package pandemic;

import javafx.scene.image.Image;

import java.util.Random;

public class Bot {

    private Room currentRoom;
    private Room[] rooms;
    private int rng;

    private Image botSprite;

    public Bot()
    {
        this.botSprite = new Image("botSpritePath.png");


    }

    public int RNG()
    {
        Random rand = new Random();

        int rng = rand.nextInt(10);
        rng += 1;

        return rng;
    }

    public void spawnBot()
    {

    }
}
