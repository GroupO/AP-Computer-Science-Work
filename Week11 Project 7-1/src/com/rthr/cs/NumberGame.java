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
 * This class plays the number game.
 * In a game of guessing numbers, one person 
 * says, "I'm thinking of a number between 1 and 
 * 100." The other person guesses "50." The first 
 * person replies, "No, the number is less." 
 * The second person guesses "25," and so on, 
 * until she guesses correctly. Write a program 
 * that plays this game. The computer knows the 
 * number and the person is the guesser. At the 
 * end of the game, have the program display the 
 * number of guesses necessary to get the correct answer. 
 * 
 * @author arthurlockman
 *
 */
public class NumberGame
{
	private int guesses, answer;
	
	/**
	 * Constructs the number game.
	 */
	public NumberGame()
	{
		//Create random number generator.
	}
	
	/**
	 * Plays the number game.
	 * @return A boolean, whether the user has completed the game or not.
	 */
	public Boolean play()
	{
		//Accept guess
		//Print whether greater or less
		finishGame();
		return false;
	}
	
	/**
	 * Print out the game statistics when the game finishes.
	 */
	private void finishGame()
	{
		System.out.println("You guessed "+guesses+" times to get the correct answer "+answer);
	}
}
