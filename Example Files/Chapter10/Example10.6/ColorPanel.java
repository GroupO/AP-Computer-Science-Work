// Example 10.6: Displays 10 circles of random color
// Allows the user to drag a circle to another position

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;            //For the mouse events
import java.util.Random;

public class ColorPanel extends JPanel{

   private Circle database[];      // The array of circles
   private Circle selectedCircle;  // Used to track selected shape
   private int x, y;               // Used to track mouse coordinates  
	
   public ColorPanel(Color backColor){
      setBackground(backColor);
      Random gen = new Random();
      database = new Circle[10];   // Create 10 circles of random color
      for (int i = 0; i < database.length; i++){
         Color color = new Color(gen.nextInt(256), gen.nextInt(256),
                                 gen.nextInt(256));
         Circle c = new Circle(i * 40, 100, 25, color);
         c.setFilled(true);
         database[i] = c;
      }
      selectedCircle = null;   
      addMouseListener(new PanelListener());
      addMouseMotionListener(new PanelMotionListener());
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      for (Circle c : database)     // Draw all the circles
          c.draw(g);      
   }

   private class PanelListener extends MouseAdapter{

      public void mousePressed(MouseEvent e){
         //Select a circle if it contains the mouse coordinates
         x = e.getX();
         y = e.getY();
         // Search for a circle, starting with the last one added
         for (int i = database.length - 1; i >= 0; i--)  
            if (database[i].containsPoint(x, y)){
               selectedCircle = database[i];
               break;
            }
      }

      public void mouseReleased(MouseEvent e){
         //Deselect the selected circle
         x = e.getX();
         y = e.getY();
         selectedCircle = null;
      }        
   }

   private class PanelMotionListener extends MouseMotionAdapter{

      public void mouseDragged(MouseEvent e){
         //Compute the distance and move the selected circle
         int newX = e.getX();
         int newY = e.getY();
         int dx = newX - x;
         int dy = newY - y;
         if (selectedCircle != null)
            selectedCircle.move(dx, dy);
         x = newX;
         y = newY; 
         repaint();
      }
   } 
}
