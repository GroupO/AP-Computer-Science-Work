import TurtleGraphics.*;
import javax .swing.*;
import java.awt.*;

public class TestFourPens{

   public static void main(String[] args){
      // Create the window
      JFrame theGUI = new JFrame();
      // Create the pads
      SketchPad pad1 = new SketchPad();
      SketchPad pad2 = new SketchPad ();
      SketchPad pad3 = new SketchPad ();
      SketchPad pad4 = new SketchPad ();
      pad1.setBackground(Color.red);
      pad2.setBackground(Color.yellow);
      pad3.setBackground(Color.lightGray);
      pad4.setBackground(Color.pink);
      // Associate the pads with pens
      Pen pen1 = new StandardPen(pad1);
      Pen pen2 = new WigglePen(pad2, 5, 30);
      Pen pen3 = new RainbowPen(pad3);
      Pen pen4 = new WiggleRainbowPen(pad4, 10, 60);
      // Set the window’s layout and add the pads to the window
      Container container = theGUI.getContentPane();
      container.setLayout(new GridLayout(2, 2));
      container.add(pad1);
      container.add(pad2);
      container.add(pad3);
      container.add(pad4);
      // Set the dimensions and show the window
      theGUI.setSize(400, 400);
      theGUI.setVisible(true);
      // Manipulate the pens
      drawSquare(pen1);
      drawSquare(pen2);
      drawSquare(pen3);
      drawSquare(pen4);
   }

   // Helper method
   private static void drawSquare(Pen pen){
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