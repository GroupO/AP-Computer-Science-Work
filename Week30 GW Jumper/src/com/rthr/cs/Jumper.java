/**
 * Author:  Arthur Lockman
 * Date:    Apr 15, 2013
 * School:  Gorham High School
 * 
 * Project: Week30 GW Jumper
 * Package: com.rthr.cs
 */
package com.rthr.cs;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * @author arthurlockman
 *
 */
public class Jumper extends Actor
{

	/**
	 * @brief The constructor for the Jumper.
	 */
	public Jumper()
	{
		//Done.
	}
	
	public void act()
	{
		if (canMove())
			move();
		else 
			turn();
	}
	/**
	 * @brief Move to the next square.
	 */
	public void move()
	{
       Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
	}
	
    /**
     * @breif Turns the jumper 45 degrees to the right without changing its location.
     */
    public void turn()
    {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }
	
	/**
	 * @brief Whether or not the jumper can move to the next position.
	 * @return A bool, whether or not the move is valid.
	 */
	public boolean canMove()
	{
		Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        
        Actor neighbor = gr.get(next);
        return (neighbor == null);
	}
}
