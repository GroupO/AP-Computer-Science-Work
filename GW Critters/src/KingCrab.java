import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

import java.util.ArrayList;

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
public class KingCrab extends CrabCritter
{
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (!(a instanceof Rock))
            {
                int dir = getLocation().getDirectionToward(a.getLocation());
                if (getGrid().isValid(a.getLocation().getAdjacentLocation(dir)))
                	a.moveTo(a.getLocation().getAdjacentLocation(dir));
                else
                	a.removeSelfFromGrid();
            }
        }
    }
}
