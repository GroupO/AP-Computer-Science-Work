// Example 7.3: Display a table of names and salaries

import java.io.*;
import java.util.Scanner;

public class DisplayTable{

   public static void main(String[] args) throws IOException{
      Scanner names = new Scanner(new File("names.txt"));
      Scanner salaries = new Scanner(new File("salaries.txt"));
      System.out.printf("%-16s%12s%n", "NAME", "SALARY");
      while (names.hasNext()){
         String name = names.nextLine();
         double salary = salaries.nextDouble();
         System.out.printf("%-16s%,12.2f%n", name, salary);
      }      
   }
}
