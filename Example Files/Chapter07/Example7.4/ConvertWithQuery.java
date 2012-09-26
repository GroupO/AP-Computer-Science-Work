/* Example 7.4: ConvertWithQuery.java
Repeatedly convert from Fahrenheit to Celsius until the user
signals the end. Recovers from a number format error with an
error message.
*/

import java.util.Scanner;

public class ConvertWithQuery {
   public static void main(String [] args) {
      Scanner reader = new Scanner(System.in);
      Thermometer thermo = new Thermometer();
      String doItAgain = "y";             
   
      while (doItAgain.equals("y") || doItAgain.equals("Y")){
         // Nested loop until input number is well-formed
         while (true)
            try{
               // Attempt statements that might throw exceptions
               System.out.print("\nEnter degrees Fahrenheit: ");
               thermo.setFahrenheit(reader.nextDouble());
               break;
            }catch(Exception e){
               // Code for error recovery
               System.out.println("Error in number format!");
               // Consume the trailing end of line
               reader.nextLine();
            }
         System.out.println("The equivalent in Celsius is " + 
                            thermo.getCelsius());
         System.out.print("\nDo it again (y/n)? ");  
         // Consume the trailing end of line
         reader.nextLine();  
         doItAgain = reader.nextLine();
      }
   }
}
