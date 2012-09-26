// A color panel whose background color is provided 
// by the client

import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{
   
   public ColorPanel(Color backColor){
      setBackground(backColor);
   }
}