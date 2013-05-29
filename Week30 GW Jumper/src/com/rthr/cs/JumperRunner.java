/**
 * Author:  Arthur Lockman
 * Date:    Apr 15, 2013
 * School:  Gorham High School
 * 
 * Project: Week30 GW Jumper
 * Package: com.rthr.cs
 */
package com.rthr.cs;

import java.awt.Color;

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

/**
 * @author arthurlockman
 * @brief Runs the Jumper class.
 */
public class JumperRunner
{
	public static void main(String[] args)
	{
		ActorWorld world = new ActorWorld();
		Jumper j = new Jumper();
		j.setColor(Color.yellow);
		Rock r = new Rock();
		world.add(new Location(5, 5), j);
		world.add(new Location(7, 5), r);
		world.show();
	}
}
