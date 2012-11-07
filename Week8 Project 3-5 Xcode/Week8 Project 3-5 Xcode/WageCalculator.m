//
//  WageCalculator.m
//  Week8 Project 3-5 Xcode
//
//  Created by Arthur Lockman on 10/24/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import "WageCalculator.h"

@implementation WageCalculator

@synthesize hourlyWage, overtimeHours, regularHours, data, employeeName;

/**
 Run the program.
 */
- (void) run
{
	[self openFile:@"/Users/arthurlockman/Dropbox/School/AP CS/Work/Data Files/VHSP35data1_1.txt"];
	[self parseData];
	NSLog(@"Employee %@ earned %@ this week.",employeeName,[self round2:[self calculatePay] andFormat:NSNumberFormatterCurrencyStyle]);
}

/**
 Opens and reads in the data from the data file.
 @param filePath The path to the file on the filesystem.
 */
- (void) openFile:(NSString *)filePath
{
	NSError *fOpenError;
	data = [[NSString alloc] initWithContentsOfFile:filePath
										   encoding:NSUTF8StringEncoding error:&fOpenError];
	if (data == nil)
	{
		NSLog(@"%@",[fOpenError localizedFailureReason]);
		exit(1);
	}
}

/**
 Parses the data from the data file.
 */
- (void) parseData
{
	NSArray* parsedData = [data componentsSeparatedByString:@" "];
	employeeName = [NSString stringWithFormat:@"%@ %@",parsedData[0],parsedData[1]];
	hourlyWage = [parsedData[2] doubleValue];
	
	for (int i=3; i<12; i=i+2)
	{
		regularHours = regularHours + [parsedData[i] doubleValue];
		overtimeHours = overtimeHours + [parsedData[i+1] doubleValue];
	}
}

/**
 Calculates the employee's pay.
 @return The pay for the employee this week.
 */
- (double) calculatePay
{
	return hourlyWage * regularHours + hourlyWage * 1.5 * overtimeHours;
}

/**
 Round a double to two decimal places.
 @param number The number to round.
 @param style The style to format the number in.
 @return An NSString, the formatted rounded number.
 */
- (NSString*) round2:(double)number andFormat:(NSNumberFormatterStyle)style
{
	NSNumberFormatter* formatter = [NSNumberFormatter new];
	[formatter setNumberStyle:style];
	NSString* num = [formatter stringFromNumber:[NSNumber numberWithDouble:number]];
	return num;
}

@end
