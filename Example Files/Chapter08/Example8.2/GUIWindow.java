// Example 8.2: An applet with a specialized panel

import javax.swing.*;
import java.awt.*;

public class GUIWindow extends JApplet{

   public void init(){
      ColorPanel panel = new ColorPanel(Color.black);
      Container pane = getContentPane();
      pane.add(panel);
   }
}