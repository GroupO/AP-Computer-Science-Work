// Example 5.3: Displays a circle and a filed circle

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{

   private Circle c1, c2;
	
   public ColorPanel(Color backColor){
      setBackground(backColor);
      c1 = new Circle(200, 100, 25, Color.red);
      c2 = new Circle(100, 100, 50, Color.blue);   
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      c1.fill(g);
      c2.draw(g);      
   }
}