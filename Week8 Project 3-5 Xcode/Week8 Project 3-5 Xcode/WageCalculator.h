//
//  WageCalculator.h
//  Week8 Project 3-5 Xcode
//
//  Created by Arthur Lockman on 10/24/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import <Foundation/Foundation.h>
#include <stdio.h>

@interface WageCalculator : NSObject

@property double hourlyWage, overtimeHours, regularHours;
@property NSString* data;
@property NSString* employeeName;

- (void) run;
- (void) openFile:(NSString*)filePath;
- (void) parseData;
- (double) calculatePay;
- (NSString*) round2:(double)number andFormat:(NSNumberFormatterStyle)style;

@end
