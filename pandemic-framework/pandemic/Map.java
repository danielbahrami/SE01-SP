package pandemic;

public class Map {

        public void minimap(int height, int width)
        {
            for (int i = 0; i < height; i++)
            {
                if (i == 0 || i == height - 1)
                {
                    for (int j = 0; j < width; j++)
                    {
                        System.out.print("_");
                    }
                    System.out.println("");
                }
            else
                {
                    for (int j = 0; j < width; j++)
                    {
                        if (j == 0 || j == width - 1)
                        {
                            System.out.print("|");
                        }
                    else
                        {
                            System.out.print(" ");
                        }
                    }
                    System.out.println("");
                }
            }
        }

    public static void main(String[] args) {

        Map map = new Map();
        map.minimap(10,10);

    }

    }


