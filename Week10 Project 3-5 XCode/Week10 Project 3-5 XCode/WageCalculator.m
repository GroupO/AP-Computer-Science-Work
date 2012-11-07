//
//  WageCalculator.m
//  Week10 Project 3-5 Xcode
//
//  Created by Arthur Lockman on 11/7/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import "WageCalculator.h"

@implementation WageCalculator

@synthesize data;

/**
 Run the program.
 */
- (void) run
{
	[self openFile:@"/Users/arthurlockman/Dropbox/School/AP CS/Work/Data Files/VHSP35data.txt"];
	[self parseData];
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
	NSArray* parsedLines = [data componentsSeparatedByString:@"\n"];
	for (int i = 0; i < [parsedLines count]; i++)
	{
		NSArray* parsedData = [parsedLines[i] componentsSeparatedByString:@" "];
		NSString* employeeName = [NSString stringWithFormat:@"%@ %@",parsedData[0],parsedData[1]];
		
		double hourlyWage = [parsedData[2] doubleValue];
		double regularHours = 0;
		double overtimeHours = 0;
		
		for (int i=3; i<12; i=i+2)
		{
			regularHours = regularHours + [parsedData[i] doubleValue];
			overtimeHours = overtimeHours + [parsedData[i+1] doubleValue];
		}
		
		double totalPay = [self calculatePay:hourlyWage regularHours:regularHours overtimeHours:overtimeHours];
		
		[self printDataForEmployee:employeeName withTotalPay:totalPay];
	}
}

/**
 Prints data for a specified employee.
 @param employeeName The name of the employee.
 @param totalHours The total pay the employee earned.
 */
- (void) printDataForEmployee:(NSString *)employeeName withTotalPay:(double)totalPay
{
		NSLog(@"Employee %@ earned %@ this week.",employeeName,[self round2:totalPay andFormat:NSNumberFormatterCurrencyStyle]);
}

/**
 Calculates the employee's pay.
 @return The pay for the employee this week.
 */
- (double) calculatePay:(double)hourlyWage regularHours:(double)regularHours overtimeHours:(double)overtimeHours
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
