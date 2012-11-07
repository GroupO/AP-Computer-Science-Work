//
//  WageCalculator.h
//  Week10 Project 3-5 Xcode
//
//  Created by Arthur Lockman on 11/7/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface WageCalculator : NSObject

@property NSString* data;

- (void) run;
- (void) openFile:(NSString*)filePath;
- (void) parseData;
- (double) calculatePay:(double)hourlyWage regularHours:(double)regularHours overtimeHours:(double)overtimeHours;
- (void) printDataForEmployee:(NSString*)employeeName withTotalPay:(double)totalPay;
- (NSString*) round2:(double)number andFormat:(NSNumberFormatterStyle)style;

@end
