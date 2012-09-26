// Example 4.7: A color panel whose background is
// a color provided by the client
// A client-specified preferred size is optional

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
}
