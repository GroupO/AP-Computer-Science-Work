// Example 18.1

import java.util.Scanner;

public class TestHashing{
   public static void main(String [] args){
      Scanner reader = new Scanner(System.in);
      String query = "y";
      while (query.equalsIgnoreCase("y")){
         System.out.print("Enter the size of the array: ");
         int arrayLength = reader.nextInt();
         System.out.print("Enter the number of items: ");
         int numberOfItems = reader.nextInt();

         System.out.println(" Item    hash code  array index");
  
         for (int i = 0; i < numberOfItems; i ++){
            String str = "Item " + i;
            int code = str.hashCode();
            int index = Math.abs(code % arrayLength);
            System.out.println(str + " " + code + " " + index);
         }
         reader.nextLine();
         System.out.print("Run again?[y/n] ");
         query = reader.nextLine();
      }
   }
}