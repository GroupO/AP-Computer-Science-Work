/**
 * Author:  Arthur Lockman
 * Date:    Nov 16, 2012
 * School:  Gorham High School
 * 
 * Project: Week11 Project 7-1
 * Package: com.rthr.cs
 */
package com.rthr.cs;

import java.util.Scanner;

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
	private Boolean correct = false;
	
	/**
	 * Constructs the number game.
	 */
	public NumberGame()
	{
		answer = this.getRandomNumber();
	}
	
	/**
	 * Plays the number game.
	 * @return A boolean, whether the user has completed the game or not.
	 */
	public Boolean play()
	{
		System.out.println("Let's play a game.\nI'm thinking " +
				"of a number between 1 and 100. Can you guess what it is?" +
				"\n(Please input a counting number as your guess, i.e. 1, 2, 3, 4)");
		while (!correct)
		{
			guesses++;
			
			int guess = this.getGuess();
			if (guess == answer)
				correct = true;
			else if (guess > answer)
				System.out.println("The number is less than your guess.");
			else if (guess < answer)
				System.out.println("The number is greater than your guess.");
		}
		finishGame();
		return false;
	}
	
	/**
	 * Gets a guess from the player.
	 * @return An int, the guess the player entered.
	 */
	private int getGuess()
	{
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}
	
	/**
	 * Get a random number to play the game.
	 * @return A random int, from 1 to 100.
	 */
	private int getRandomNumber()
	{
		return 1 + (int)(Math.random() * ((100 - 1) + 1));
	}
	
	/**
	 * Print out the game statistics when the game finishes.
	 */
	private void finishGame()
	{
		System.out.println("That's correct!\nYou guessed "+guesses+
				" times to get the correct answer "+answer);
	}
}
