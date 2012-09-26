import javax.swing.*;
import java.awt.*;

public class GUIWindow extends JFrame{

   public static void main (String[] args){
      GUIWindow theGUI = new GUIWindow();
      theGUI.setSize(100, 100);
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ColorPanel panel = new ColorPanel(Color.white);
      Container pane = theGUI.getContentPane();
      pane.add(panel);
      theGUI.setVisible(true);
   }
}

