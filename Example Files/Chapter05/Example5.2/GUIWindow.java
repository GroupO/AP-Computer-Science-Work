// Example 5.2: Loading an image from a file

import javax.swing.*;
import java.awt.*;

public class GUIWindow{

   public static void main(String[] args){
      JFrame theGUI = new JFrame();
      theGUI.setTitle("GUI Program");
      theGUI.setSize(300, 300);
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ImageIcon image = new ImageIcon("smokey.jpg");
      ColorPanel panel = new ColorPanel(Color.black, image);
      Container pane = theGUI.getContentPane();
      pane.add(panel);
      theGUI.setVisible(true);
   }
}