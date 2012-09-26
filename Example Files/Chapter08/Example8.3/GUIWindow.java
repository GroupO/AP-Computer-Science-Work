// Example 8.3: Loading an image from a file (applet)

import javax.swing.*;
import java.awt.*;

public class GUIWindow extends JApplet{

   public void init(){
      // Locate this applet’s Web server and load the image
      Image image = getImage(getDocumentBase(), "smokey.jpg");
      // Convert to an image icon for further processing
      ImageIcon imageIcon = new ImageIcon(image);
      ColorPanel panel = new ColorPanel(Color.black, imageIcon);
      Container pane = getContentPane();
      pane.add(panel);
   }
}