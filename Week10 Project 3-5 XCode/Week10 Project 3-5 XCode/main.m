//
//  main.m
//  Week10 Project 3-5 XCode
//
//  Created by Arthur Lockman on 11/7/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "WageCalculator.h"

int main(int argc, const char * argv[])
{
	
	@autoreleasepool
	{
	    WageCalculator* wCalc = [WageCalculator new];
		[wCalc run];
	}
    return 0;
}

