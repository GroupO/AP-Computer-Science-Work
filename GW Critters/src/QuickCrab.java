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
public class QuickCrab extends CrabCritter
{
    public void makeMove(Location loc)
    {
        if (loc.equals(getLocation()))
        {
            double r = Math.random();
            int angle;
            if (r < 0.5)
                angle = Location.LEFT;
            else
                angle = Location.RIGHT;
            setDirection(getDirection() + angle);
        }
        else
        {
        	if (getGrid().get(loc.getAdjacentLocation(getLocation().getDirectionToward(loc))) == null)
        		super.makeMove(loc.getAdjacentLocation(getLocation().getDirectionToward(loc)));
        	else
        		super.makeMove(loc);
        }
    }
}
