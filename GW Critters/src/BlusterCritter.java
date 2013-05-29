import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * Author:  Arthur Lockman
 * Date:    Apr 16, 2013
 * School:  Gorham High School
 * 
 * Project: GW Critters
 * Package: 
 */

/**
 * @author arthurlockman
 *
 */
public class BlusterCritter extends Critter
{
	private int courage;
	public BlusterCritter(int c)
	{
		courage = c;
	}
	
    public ArrayList<Actor> getActors()
    {
    	ArrayList<Actor> a = new ArrayList<Actor>();
    	a.addAll(getGrid().getNeighbors(getLocation()));
    	for (Location loc : getGrid().getValidAdjacentLocations(getLocation()))
    	{
    		a.addAll(getGrid().getNeighbors(loc));
    	}
    	return a;
    }
    
    public void processActors(ArrayList<Actor> actors)
    {
    	if (actors.size() < courage)
    		brighten();
    	else if (actors.size() >= courage)
    		darken();
    }
    
    private void darken()
    {
    	Color c = getColor();
        int red = (int) (c.getRed() * (1 - 0.05));
        int green = (int) (c.getGreen() * (1 - 0.05));
        int blue = (int) (c.getBlue() * (1 - 0.05));
        setColor(new Color(red, green, blue));
    }
    
    private void brighten()
    {
    	Color c = getColor();
        int red = (int) (c.getRed() * (1 + 0.05));
        int green = (int) (c.getGreen() * (1 + 0.05));
        int blue = (int) (c.getBlue() * (1 + 0.05));
        setColor(new Color(red, green, blue));
    }
}
