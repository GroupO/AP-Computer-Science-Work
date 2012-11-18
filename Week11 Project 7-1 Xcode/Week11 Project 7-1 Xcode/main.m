//  This project plays a simple number guessing game.
//
//  main.m
//  Week11 Project 7-1 Xcode
//
//  Created by Arthur Lockman on 11/17/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "NumberGame.h"

int main(int argc, const char * argv[])
{

	@autoreleasepool
	{
		NumberGame* game = [NumberGame new];
		[game setupGame];
		[game play];
	}
    return 0;
}

