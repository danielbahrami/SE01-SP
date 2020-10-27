package pandemic;

import java.util.Random;

public class Bot {

    private Room currentRoom;
    private Room[] rooms;
    private int rng;

    public Bot()
    {

        rooms = new Room[10];

        for (int i = 0; i < rooms.length; i++)
        {

        }
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
