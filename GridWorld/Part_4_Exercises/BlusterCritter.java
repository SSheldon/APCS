package Part_4_Exercises;

import info.gridworld.actor.Critter;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

public class BlusterCritter extends Critter
{
    private final int c;
    private float[] hsb;
    
    public BlusterCritter(int c)
    {
        this.c = c;
        setColor(Color.BLUE);
    }
    
    public void setColor(Color newColor)
    {
        hsb = Color.RGBtoHSB(newColor.getRed(), newColor.getGreen(),
            newColor.getBlue(), null);
        super.setColor(newColor);
    }
    
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        Grid<Actor> grid = getGrid();
        Location loc = getLocation();
        for (int r = loc.getRow() - 2; r < loc.getRow() + 2; r++)
        {
            for (int c = loc.getCol() - 2; c < loc.getCol() + 2; c++)
            {
                Location l = new Location(r, c);
                if (grid.isValid(l))
                {
                    Actor a = grid.get(l);
                    if (a != null && a != this) actors.add(a);
                }
            }
        }
        return actors;
    }
    
    public void processActors(ArrayList<Actor> actors)
    {
        int critters = 0;
        for (Actor actor : actors)
            if (actor instanceof Critter) critters++;
        if (critters < c) brighten();
        else darken();
    }
    
    private void darken()
    {
        hsb[2] -= 0.1 * hsb[2];
        setColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    }
    
    private void brighten()
    {
        hsb[2] += 0.1 * (1 - hsb[2]);
        setColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
    }
}