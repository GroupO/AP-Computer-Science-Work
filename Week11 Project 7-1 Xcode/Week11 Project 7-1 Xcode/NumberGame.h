//
//  NumberGame.h
//  Week11 Project 7-1 Xcode
//
//  Created by Arthur Lockman on 11/17/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

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

#import <Foundation/Foundation.h>

@interface NumberGame : NSObject
@property int guesses, answer;
@property BOOL correct;

- (void) setupGame;
- (void) play;
- (void) finishGame;

- (int) getGuess;

@end
