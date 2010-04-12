package Part_2_Exercises;

import info.gridworld.actor.Bug;

public class DancingBug extends Bug
{
    int[] turns;
    int steps;
    
    public DancingBug(int[] turns)
    {
        this.turns = turns;
        steps = 0;
    }
    
    public void act()
    {
        if (steps >= turns.length) steps = 0;
        for (int i = 0; i < turns[steps]; i++) turn();
        steps++;
        super.act();
    }
}
