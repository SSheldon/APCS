package Part_2_Exercises;

import info.gridworld.actor.Bug;

public class ZBug extends Bug
{
    private int steps;
    private int sideLength, side;

    public ZBug(int length)
    {
        steps = 0;
        side = 0;
        sideLength = length;
    }

    public void act()
    {
        if (side < 3 && canMove())
        {
            if (steps < sideLength)
            {
                move();
                steps++;
            }
            else
            {
                switch (side)
                {
                    case 0:
                        turn(); turn(); turn(); break;
                    case 1:
                        turn(); turn(); turn(); turn(); turn(); break;
                }
                side++;
                steps = 0;
            }
        }
    }
}