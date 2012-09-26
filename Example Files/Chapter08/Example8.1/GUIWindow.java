/* GUIWindow.java
The main view for a GUI-based temperature conversion 
program that coverts from Fahrenheit to Celsius and back again.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIWindow extends JApplet{

   // >>>>>>> The model <<<<<<<<

   // Declare and intantiate the thermometer    
   private Thermometer thermo = new Thermometer();

   // >>>>>>> The view <<<<<<<<

   // Declare and instantiate the window objects.
   private JLabel fahrLabel        = new JLabel("Degrees Fahrenheit");
   private JLabel celsiusLabel     = new JLabel("Degrees Celsius");         
   private JTextField fahrField    = new JTextField("32.0");  
   private JTextField celsiusField = new JTextField("0.0");
   private JButton fahrButton      = new JButton("Convert >>>");
   private JButton celsiusButton   = new JButton("<<< Convert");

   // Constructor
   public void init(){
      // Set up panels to organize widgets and
      // add them to the window
      JPanel dataPanel = new JPanel(new GridLayout(2, 2, 12, 6));
      dataPanel.add(fahrLabel);
      dataPanel.add(celsiusLabel);
      dataPanel.add(fahrField);
      dataPanel.add(celsiusField);
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(fahrButton);
      buttonPanel.add(celsiusButton);
      Container container = getContentPane();
      container.add(dataPanel, BorderLayout.CENTER);
      container.add(buttonPanel, BorderLayout.SOUTH);
      // Attach a listener to the convert button
      fahrButton.addActionListener(new FahrenheitListener()); 
      celsiusButton.addActionListener(new CelsiusListener()); 
   }
   
   // >>>>>>> The controller <<<<<<<<

   private class FahrenheitListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         try{
            String input = fahrField.getText();       // Obtain input
            double fahr = Double.parseDouble(input);  // Convert to double
            thermo.setFahrenheit(fahr);               // Reset thermometer
            double celsius = thermo.getCelsius();     // Obtain Celsius
            celsiusField.setText("" + celsius);       // Output result
         }catch(Exception ex){
            JOptionPane.showMessageDialog(GUIWindow.this, 
                                          "Bad number format",
                                          "Temperature Converter",
                                          JOptionPane.ERROR_MESSAGE);
         }
      }
   }

   private class CelsiusListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         String input = celsiusField.getText();        // Obtain input
         double celsius = Double.parseDouble(input);   // Convert to double
         thermo.setCelsius(celsius);                   // Reset thermometer
         double fahr = thermo.getFahrenheit();         // Obtain Fahrenheit
         fahrField.setText("" + fahr);                 // Output result
      }
   }

}
