//
//  VowelWorker.h
//  Week15 Vowels R Us Xcode
//  This class does the word processing work.
//
//  Created by Arthur Lockman on 12/6/12.
//  Copyright (c) 2012 Arthur Lockman. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface VowelWorker : NSObject

@property NSString* dataString;
@property NSArray* data;

- (void) run;
- (void) getDataFromFilePath:(NSString*)filePath;
- (void) processLine:(NSString*)line;
- (BOOL) isVowel:(char)ch;

@end
