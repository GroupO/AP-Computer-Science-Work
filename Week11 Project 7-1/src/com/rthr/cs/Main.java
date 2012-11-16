/**
 * Author:  Arthur Lockman
 * Date:    Nov 16, 2012
 * School:  Gorham High School
 * 
 * Project: Week11 Project 7-1
 * Package: com.rthr.cs
 */
package com.rthr.cs;

/**
 * @author arthurlockman
 *
 */
public class Main
{
	/**
	 * The main loop for the number game.
	 * @param args
	 */
	public static void main(String[] args)
	{
		NumberGame numberGame = new NumberGame();
		
		if (numberGame.play())
			System.exit(0);
	}
}
