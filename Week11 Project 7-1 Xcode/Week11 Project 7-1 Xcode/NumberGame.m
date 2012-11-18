//
//  NumberGame.m
//  Week11 Project 7-1 Xcode
//
//  Created by Arthur Lockman on 11/17/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import "NumberGame.h"

@implementation NumberGame
@synthesize guesses, answer, correct;

/**
 * Sets up the number game.
 */
 - (void) setupGame
{
	guesses = 0;
	answer = arc4random_uniform(99) + 1;
}

/**
 * Plays the number game.
 * @return A boolean, whether the user has completed the game or not.
 */
- (void) play
{
	NSLog(@"Let's play a game.\nI'm thinking of a number between 1 and 100. Can you guess what it is?\n(Please input a counting number as your guess, i.e. 1, 2, 3, 4)");
	while (!correct)
	{
		guesses++;
		
		int guess = [self getGuess];
		if (guess == answer)
			correct = true;
		else if (guess > answer)
			NSLog(@"The number is less than your guess.");
		else if (guess < answer)
			NSLog(@"The number is greater than your guess.");
	}
	[self finishGame];
}

/**
 * Print out the game statistics when the game finishes.
 */
- (void) finishGame
{
	NSLog(@"That's correct!\nYou guessed %i times to get the correct answer %i.", guesses, answer);
}

/**
 * Gets a guess from the player.
 * @return An int, the guess the player entered.
 */
- (int) getGuess
{
	int guess;
	scanf("%i",&guess);
	return guess;
}

@end
