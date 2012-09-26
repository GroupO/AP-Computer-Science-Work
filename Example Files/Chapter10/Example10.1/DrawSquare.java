// Example 10.1: Draw a square using Turtle Graphics

import TurtleGraphics.StandardPen;

public class DrawSquare {
   public static void main(String [] args) {

      // Instantiate a pen object
      StandardPen pen = new StandardPen();
      
      // Lift the pen, move it to the square’s top left corner,
      // and lower it again
      pen.up();
      pen.move(25);
      pen.turn(90); pen.move(25);
      pen.down();
      
      // Draw the square
      pen.turn(90); pen.move(50); 
      pen.turn(90); pen.move(50); 
      pen.turn(90); pen.move(50);
      pen.turn(90); pen.move(50);
   }
}
