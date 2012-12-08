//
//  main.m
//  Week15 Vowels R Us Xcode
//  This is the main method for the Vowels R Us project.
//
//  Created by Arthur Lockman on 12/6/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "VowelWorker.h"
int main(int argc, const char * argv[])
{

	@autoreleasepool
	{
	    VowelWorker* vowelWorker = [[VowelWorker alloc] init];
		[vowelWorker run];
	}
    return 0;
}

