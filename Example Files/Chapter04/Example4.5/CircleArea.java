// Example 4.5: CircleARea with dialog I/O

import javax.swing.JOptionPane;

public class CircleArea{

   public static void main(String[] args){
      String inputStr = JOptionPane.showInputDialog("Enter the radius",
                                                    "0");
      if (inputStr == null)
         return;
      double radius = Double.parseDouble(inputStr);
      if (radius < 0)
         JOptionPane.showMessageDialog(null, "Error: Radius must be >= 0");
      else{
         double area = Math.PI * Math.pow(radius, 2);
         JOptionPane.showMessageDialog(null, "The area is " + area);
      }
   }
}
