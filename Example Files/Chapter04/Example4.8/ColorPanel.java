// Example 4.8: A colored panel containing 
// a red and white bull's eye

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{
	
   // Client provides color and preferred width and height
   public ColorPanel(Color backColor, int width, int height){
      setBackground(backColor);
      setPreferredSize(new Dimension(width, height));
   }

   // Client provides color 
   // Preferred width and height are 0, 0 by default   
   public ColorPanel(Color backColor){
      setBackground(backColor);
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int thickness = getWidth() / 10;
      int x = 0;
      int y = 0;
      int width = getWidth() - 1;
      int height = getHeight() - 1;
      Color ringColor = Color.red;

      for (int count = 1; count <= 5; count++){
         g.setColor(ringColor);
         g.fillOval(x, y, width, height);
         
         //Adjust corner point for next oval
         x = x + thickness;
         y = y + thickness;
         
         //Adjust width and height for next oval
         width = width - thickness * 2;
         height = height - thickness * 2;
         
         //Change the color for the next oval
         if (ringColor == Color.red)
            ringColor = Color.white;
         else
            ringColor = Color.red;
      }     
   }	
}
