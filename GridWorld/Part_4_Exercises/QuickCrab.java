package Part_4_Exercises;

import critters.CrabCritter;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

public class QuickCrab extends CrabCritter
{
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Location loc = getLocation();
        
        int rD = getDirection() + Location.RIGHT;
        Location rL = loc.getAdjacentLocation(rD);
        Location rL2 = rL.getAdjacentLocation(rD);
        if (canMoveTo(rL) && canMoveTo(rL2))
            locs.add(rL2);
        
        int lD = getDirection() + Location.LEFT;
        Location lL = loc.getAdjacentLocation(lD);
        Location lL2 = lL.getAdjacentLocation(lD);
        if (canMoveTo(lL) && canMoveTo(lL2))
            locs.add(lL2);
        
        return locs;
    }
    
    private boolean canMoveTo(Location loc)
    {
        Grid<Actor> gr = getGrid();
        return gr.isValid(loc) && gr.get(loc) == null;
    }
}