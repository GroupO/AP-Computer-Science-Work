/* ConvertWithGUI.java
Application class for a GUI-based temperature conversion 
program that coverts from Fahrenheit to Celsius.
*/

import javax.swing.*;

public class ConvertWithGUI{
    
   // Execution begins in the method main as usual.
   public static void main(String[] args){
      GUIWindow theGUI = new GUIWindow();
      theGUI.setTitle("F to C Converter");
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      theGUI.pack();    
      theGUI.setVisible(true);    //Make the window visible
   }
}

