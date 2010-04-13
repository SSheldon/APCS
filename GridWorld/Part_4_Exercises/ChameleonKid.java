package Part_4_Exercises;

import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import info.gridworld.actor.Actor;

import java.util.ArrayList;

public class ChameleonKid extends ChameleonCritter
{
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Grid<Actor> grid = getGrid();
        Location forward = getLocation().getAdjacentLocation(getDirection());
        if (grid.isValid(forward) && grid.get(forward) != null)
            actors.add(grid.get(forward));
        Location backward = getLocation().getAdjacentLocation(
            getDirection() + Location.HALF_CIRCLE);
        if (grid.isValid(backward) && grid.get(backward) != null)
            actors.add(grid.get(backward));
        return actors;
    }
}
