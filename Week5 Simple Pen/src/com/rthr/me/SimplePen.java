/**
 * Author:  Arthur Lockman
 * Date:    Sep 28, 2012
 * School:  Gorham High School
 * 
 * Project: Week5 Simple Pen
 * Package: com.rthr.me
 */
package com.rthr.me;

import java.awt.Color;

import TurtleGraphics.StandardPen;

/**
 * <p>This class is an example of a usage of TurtleGraphics.</p>
 * <p>Its job is to draw a blue square, a red square, and some text.</p>
 * 
 * @author arthurlockman
 */
public class SimplePen 
{
	/**
	 * The main loop of the SimplePen class. Draws the squares and the text.
	 * @param args Arguments to the main thread.
	 */
	public static void main(String[] args) 
	{
		StandardPen pen = new StandardPen();
		pen.up();
		pen.setColor(Color.blue);
		pen.move(25);
		pen.turn(90); 
		pen.move(25);
		pen.down();
		
		// Draw the square
		pen.turn(90); 
		pen.move(50); 
		pen.turn(90); 
		pen.move(50); 
		pen.turn(90); 
		pen.move(50);
		pen.turn(90); 
		pen.move(50);
		
		//Write the text.
		pen.up();
		pen.setColor(Color.black);
		pen.move(-100);
		pen.turn(90); 
		pen.move(100);
		pen.drawString("Two Squares");
		
		//Move into position to draw final square.
		pen.setColor(Color.red);
		pen.move(100);
		pen.turn(90);
		pen.move(200);
		pen.down();
		
		// Draw the square
		pen.turn(90); 
		pen.move(50); 
		pen.turn(90); 
		pen.move(50); 
		pen.turn(90); 
		pen.move(50);
		pen.turn(90); 
		pen.move(50);
	}
}
