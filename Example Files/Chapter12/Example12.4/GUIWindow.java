// Example 12.4: Revised temperature conversion program
// that uses a slider to view degrees Fahrenheit and degrees Celsius


import javax.swing.*;
import java.awt.*;
import javax.swing.event.*;

public class GUIWindow extends JFrame{

   // >>>>>>> The model <<<<<<<<

   // Declare and intantiate the thermometer    
   private Thermometer thermo = new Thermometer();

   // >>>>>>> The view <<<<<<<<

   // Declare and instantiate the window objects.
   private JLabel fahrLabel        = new JLabel("Degrees Fahrenheit");
   private JLabel celsiusLabel     = new JLabel("Degrees Celsius");         
   private JTextField fahrField    = new JTextField("32.0");  
   private JTextField celsiusField = new JTextField("0.0");
   // Create a slider with horizontal orientation, minimum value of -400,
   // maximum value of 400, and initially selected value of 32
   private JSlider slider = new JSlider(SwingConstants.HORIZONTAL, -400, 400, 32); 

   // Constructor
   public GUIWindow(){
      // Set up panels to organize widgets and
      // add them to the window
      JPanel dataPanel = new JPanel(new GridLayout(2, 2, 12, 6));
      dataPanel.add(fahrLabel);
      dataPanel.add(celsiusLabel);
      dataPanel.add(fahrField);
      dataPanel.add(celsiusField);
      // Single input control now is a slider
      slider.setMajorTickSpacing(50);
      slider.setPaintTicks(true);
      JPanel sliderPanel = new JPanel();
      sliderPanel.add(slider);
      Container container = getContentPane();
      container.add(dataPanel, BorderLayout.CENTER);
      container.add(sliderPanel, BorderLayout.SOUTH);
      // Attach a listener to the slider
      slider.addChangeListener(new SliderListener()); 
   }
   
   // >>>>>>> The controller <<<<<<<<

   // Single listener responds to slider movement
   private class SliderListener implements ChangeListener{
      public void stateChanged(ChangeEvent e){
         int fahr = slider.getValue();                 // Obtain slider's value
         fahrField.setText("" + fahr);                 // Output Fahrenheit value
         thermo.setFahrenheit(fahr);                   // Reset thermometer
         double celsius = thermo.getCelsius();         // Obtain Celsius value
         String str = String.format("%.2f", celsius);  // Format to 2 places
         celsiusField.setText(str);                    // Output Celsius value
      }
   }
}
