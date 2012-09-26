/* Example 7.2: ConvertWithMenu.java
A menu-driven temperature conversion program that converts from
Fahrenheit to Celsius and vice versa.
*/

import java.util.Scanner;

public class ConvertWithMenu {
   public static void main (String [] args) {
      Scanner reader = new Scanner(System.in);
      Thermometer thermo = new Thermometer();
      String menu;           //The multiline menu
      int menuOption;        //The user's menu selection
   
      //Build the menu string
      menu = "\n1) Convert from Fahrenheit to Celsius"
           + "\n2) Convert from Celsius to Fahrenheit"
           + "\n3) Quit"
           + "\nEnter your option: ";

      //Set up the menu loop
      menuOption = 4;
      while (menuOption != 3){
        
         //Display the menu and get the user's option
         System.out.print(menu);
         menuOption = reader.nextInt();
         System.out.println ("");
           
         //Determine which menu option has been selected
           
         if (menuOption == 1){        
           
            //Convert from Fahrenheit to Celsius
            System.out.print("Enter degrees Fahrenheit: ");
            thermo.setFahrenheit(reader.nextDouble());
            System.out.println ("The equivalent in Celsius is " + 
                                 thermo.getCelsius());
              
         }else if (menuOption == 2){  
           
            //Convert from Celsius to Fahrenheit
            System.out.print("Enter degrees Celsius: ");
            thermo.setCelsius(reader.nextDouble());
            System.out.println ("The equivalent in Fahrenheit is " + 
                                 thermo.getFahrenheit());
              
         }else if (menuOption == 3)  
           
            //User quits, sign off
            System.out.println("Goodbye!");

          else
            
            //Invalid option
            System.out.println ("Invalid option");
      }
   }
}
