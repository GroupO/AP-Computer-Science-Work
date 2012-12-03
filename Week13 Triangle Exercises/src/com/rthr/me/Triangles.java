/**
 * Author:  Arthur Lockman
 * Date:    Dec 1, 2012
 * School:  Gorham High School
 * 
 * Project: Week13 Triangle Exercises
 * Package: com.rthr.me
 */
package com.rthr.me;

/**
 * Draws two different triangles in text.
 * @author arthurlockman
 *
 */
public class Triangles
{

	/**
	 * The main loop. Calls the necessary methods to 
	 * draw the different triangles.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Triangles triangleDrawer = new Triangles();
		triangleDrawer.doTriangleOne();
		triangleDrawer.doTriangleTwo();
	}
	
	/**
	 * Draws triangle 1.
	 */
	public void doTriangleOne()
	{
		System.out.println("Drawing triangle 1:" +
				"\n-------------------\n");
		
		int line, stars;
		for (line = 0; line < 6; line++)
		{
			for (stars = 6; stars > line; stars--)
			{
				System.out.print('*');
			}

			System.out.println();
		}
		
		System.out.println("\n");
	}

	/**
	 * Draws triangle 2.
	 */
	public void doTriangleTwo()
	{
		System.out.println("Drawing triangle 2:" +
				"\n-------------------\n");
		
		int line = 0, spaces, numbers;
		for (line = 0; line < 6; line++)
		{
		    for (spaces = 6; spaces > line; spaces--)
		    {
		    	System.out.print(' ');
			}
		    
		    for (numbers = 0; numbers <= (line*2); numbers++)
		    {
		    	System.out.print(line);
		    }
		    
		    System.out.println();
		}
		
		System.out.println("\n");
	}
}
