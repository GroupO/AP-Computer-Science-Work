//
//  VowelWorker.m
//  Week15 Vowels R Us Xcode
//  This class does the word processing work.
//
//  Created by Arthur Lockman on 12/6/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import "VowelWorker.h"

@implementation VowelWorker

@synthesize dataString, data;

/**
 Run the Vowels R Us methods.
 */
- (void) run
{
	[self getDataFromFilePath:@"/Users/arthurlockman/Dropbox/School/AP CS/Work/Data Files/Vowels.txt"];
	
	for (int i = 0; i < [data count]; i++)
		[self processLine:data[i]];
	
	return;
}

/**
 Opens and reads in the data from the data file.
 @param filePath The path to the file on the filesystem.
 */
- (void) getDataFromFilePath:(NSString *)filePath
{
	NSError *fOpenError;
	dataString = [[NSString alloc] initWithContentsOfFile:filePath
										   encoding:NSUTF8StringEncoding error:&fOpenError];
	
	if (dataString == nil)
	{
		NSLog(@"%@",[fOpenError localizedFailureReason]);
		exit(1);
	}
	
	data = [dataString componentsSeparatedByString:@"\n"];
}

/**
 Process a line of data containing a word and a suffix.
 @param line The line to process.
 */
- (void) processLine:(NSString *)line
{
	NSArray* tmpLine = [line componentsSeparatedByString:@" "];
	NSString* word = tmpLine[0];
	NSString* suffix = tmpLine[1];
	NSString* pluralWord = [NSString new];
	NSString* suffixWord = [NSString new];
	
	//If word ends in double consonant or vowel.
	if (([self isVowel:[word characterAtIndex:([word length]-1)]]
		&& [self isVowel:[word characterAtIndex:([word length]-2)]])
		|| (![self isVowel:[word characterAtIndex:([word length]-1)]]
		&& [self isVowel:[word characterAtIndex:([word length]-1)]]))
	{
		pluralWord = [NSString stringWithFormat:@"%@%c%@",
					  word, [word characterAtIndex:([word length]-1)], @"H"];
		
		if ([self isVowel:[suffix characterAtIndex:0]])
			suffixWord = [NSString stringWithFormat:@"%@%c%@",
						  word, [suffix characterAtIndex:0], suffix];
		else if (![self isVowel:[suffix characterAtIndex:0]])
		{
			suffixWord = [NSString stringWithFormat:@"%@%c%@",
						  [word substringToIndex:[word length]-2],
						  [word characterAtIndex:[word length]-1], suffix];
		}
	}
	//If word ends in single vowel.
	else if ([self isVowel:[word characterAtIndex:([word length]-1)]])
	{
		pluralWord = [NSString stringWithFormat:@"%@%@",
					  [word substringToIndex:([word length] - 1)], @"G"];
		
		if ([self isVowel:[suffix characterAtIndex:0]])
			suffixWord = [NSString stringWithFormat:@"%@%@",
						  word, [suffix substringFromIndex:1]];
		else if (![self isVowel:[suffix characterAtIndex:0]])
			suffixWord = [NSString stringWithFormat:@"%@%c%@",
						  word, [suffix characterAtIndex:0], suffix];
	}
	//If word ends in single consonant
	else if (![self isVowel:[word characterAtIndex:([word length]-1)]])
	{
		pluralWord = [NSString stringWithFormat:@"%@%@", word, @"GH"];
		
		suffixWord = [NSString stringWithFormat:@"%@%@", word, suffix];
	}
	
	NSLog(@"Original String: %@",word);
	NSLog(@"         Plural: %@",pluralWord);
	NSLog(@"         Suffix: %@",suffixWord);
	NSLog(@"\n");
}

/**
 Tests to see whether or not a character is a vowel.
 @param ch The character to test.
 @return A bool, whether or not it's a vowel.
 */
- (BOOL) isVowel:(char)ch
{
	if (ch == 'A' || ch == 'S' || ch == 'C' || ch == 'L'
		|| ch == 'a' || ch == 's' || ch == 'c' || ch == 'l')
		return YES;
	else
		return NO;
}
@end
