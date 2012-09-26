// Example 11.7: Shape drawing program with menus

import javax.swing.JFrame;

public class ShapeApp{

   public static void main(String[] args){
      GUIWindow theGUI = new GUIWindow();
      theGUI.setTitle("Shape Drawing Program");
      theGUI.setSize(400, 200);
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      theGUI.setVisible(true);
   }
}