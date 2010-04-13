package Part_4_Exercises;

import critters.CrabCritter;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

public class KingCrab extends CrabCritter
{
    public void processActors(ArrayList<Actor> actors)
    {
        Grid<Actor> gr = getGrid();
        int d = getDirection();
        for (Actor actor : actors)
        {
            Location loc = actor.getLocation().getAdjacentLocation(d);
            if (gr.isValid(loc)) actor.moveTo(loc);
            else actor.removeSelfFromGrid();
        }
    }
}