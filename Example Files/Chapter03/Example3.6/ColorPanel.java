// Example 3.6: A colored panel containing a red text
// message in a blue rectangle

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{
	
   public ColorPanel(Color backColor){
      setBackground(backColor);
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      g.setColor(Color.blue);
      g.drawRect(10, 5, 120, 20);
      g.setColor(Color.red);
      g.drawString("Hello world!", 20, 20);
   }	
}
