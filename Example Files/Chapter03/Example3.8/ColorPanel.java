// Example 3.8: A colored panel containing a red text
// message in a blue rectangle, centered in the panel
// Text font is Courier bold 14

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{
	
   public ColorPanel(Color backColor){
      setBackground(backColor);
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      int x = getWidth() / 2 - 60;
      int y = getHeight() / 2;
      g.setColor(Color.blue);
      g.drawRect(x, y, 120, 20);
      g.setColor(Color.red);
      Font font = new Font("Courier", Font.BOLD, 14);
      g.setFont(font);
      g.drawString("Hello world!", x + 10, y + 15);
   }	
}
