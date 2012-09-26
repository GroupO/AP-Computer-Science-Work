// Solution to Project 3.7
// Displays coordinates of the center point of the panel

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{
	
   public ColorPanel(Color backColor){
      setBackground(backColor);
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int x = getWidth() / 2;
      int y = getHeight() / 2;
      g.drawString("(" + x + "," + y + ")", x, y);
   }	
}
