// Example 5.5: Displays a circle and a filled circle
// Allows the user to drag a circle to another position

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ColorPanel extends JPanel{

   private Circle c1, c2;
   private Circle selectedCircle;  // Used to track selected shape
   private int x, y;               // Used to track mouse coordinates  
	
   public ColorPanel(Color backColor){
      setBackground(backColor);
      c1 = new Circle(200, 100, 25, Color.red);
      c2 = new Circle(100, 100, 50, Color.blue);
      selectedCircle = null;   
      addMouseListener(new PanelListener());
      addMouseMotionListener(new PanelMotionListener());
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      c1.fill(g);
      c2.draw(g);      
   }

   private class PanelListener extends MouseAdapter{

      public void mousePressed(MouseEvent e){
         x = e.getX();
         y = e.getY();
         if (c1.containsPoint(x, y))
            selectedCircle = c1;
         else if (c2.containsPoint(x, y))
            selectedCircle = c2; 
      }

      public void mouseReleased(MouseEvent e){
         x = e.getX();
         y = e.getY();
         selectedCircle = null;
      }        
   }

   private class PanelMotionListener extends MouseMotionAdapter{

      public void mouseDragged(MouseEvent e){
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