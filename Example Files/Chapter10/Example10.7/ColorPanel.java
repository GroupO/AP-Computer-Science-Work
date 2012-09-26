// Example 10.7: Displays 10 shapes of random color
// Allows the user to drag a shape to another position

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;            //For the mouse events
import java.util.Random;

public class ColorPanel extends JPanel{

   private Shape database[];      // The array of shapes
   private Shape selectedShape;   // Used to track selected shape
   private int x, y;              // Used to track mouse coordinates  
	
   public ColorPanel(Color backColor){
      setBackground(backColor);
      Random gen = new Random();
      database = new Shape[10];   // Create 10 shapes of random color
      for (int i = 0; i < database.length; i++){
         Color color = new Color(gen.nextInt(256), gen.nextInt(256),
                                 gen.nextInt(256));
         // Flip a coin to determine which type of shape to create
         Shape s;
         if (gen.nextInt(2) == 1) 
            s = new Circle(i * 40, 50, 25, color);
         else
            s = new Rect(i * 40, 100, 50, 50, color);
         s.setFilled(true);
         database[i] = s;
      }
      selectedShape = null;   
      addMouseListener(new PanelListener());
      addMouseMotionListener(new PanelMotionListener());
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      for (Shape s : database)     // Draw all the shapes
          s.draw(g);      
   }

   private class PanelListener extends MouseAdapter{

      public void mousePressed(MouseEvent e){
         //Select a shape if it contains the mouse coordinates
         x = e.getX();
         y = e.getY();
         // Search for a shape, starting with the last one added
         for (int i = database.length - 1; i >= 0; i--)  
            if (database[i].containsPoint(x, y)){
               selectedShape = database[i];
               break;
            }
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
