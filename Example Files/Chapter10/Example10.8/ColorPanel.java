// Example 10.8: Displays 10 shapes of random color
// Allows the user to drag a shape to another position
// Uses a distinct data model to maintain the shapes

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;            //For the mouse events
import java.util.Random;

public class ColorPanel extends JPanel{

   private ShapeModel database;   // Now just a model
   private Shape selectedShape;   // Used to track selected shape
   private int x, y;              // Used to track mouse coordinates  
	
   public ColorPanel(Color backColor){
      setBackground(backColor);
      Random gen = new Random();
      database = new ShapeModel(10);  // Create a model for 10 shapes
      for (int i = 0; i < 10; i++){
         Color color = new Color(gen.nextInt(256), gen.nextInt(256),
                                 gen.nextInt(256));
         // Flip a coin to determine which type of shape to create
         Shape s;
         if (gen.nextInt(2) == 1) 
            s = new Circle(i * 40, 50, 25, color);
         else
            s = new Rect(i * 40, 100, 50, 50, color);
         s.setFilled(true);
         database.add(s);       // No more array access
      }
      selectedShape = null;   
      addMouseListener(new PanelListener());
      addMouseMotionListener(new PanelMotionListener());
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      // Draw all the shapes
      database.draw(g);         // Piece of cake!     
   }

   private class PanelListener extends MouseAdapter{

      public void mousePressed(MouseEvent e){
         //Select a shape if it contains the mouse coordinates
         x = e.getX();
         y = e.getY();
         // Search returns the shape or null
         selectedShape = database.containsPoint(x, y);
      }

      public void mouseReleased(MouseEvent e){
         //Deselect the selected shape
         x = e.getX();
         y = e.getY();
         selectedShape = null;
      }        
   }

   private class PanelMotionListener extends MouseMotionAdapter{

      public void mouseDragged(MouseEvent e){
         //Compute the distance and move the selected shape
         int newX = e.getX();
         int newY = e.getY();
         int dx = newX - x;
         int dy = newY - y;
         if (selectedShape != null)
            selectedShape.move(dx, dy);
         x = newX;
         y = newY; 
         repaint();
      }
   } 
}
