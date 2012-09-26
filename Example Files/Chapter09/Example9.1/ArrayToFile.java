// Example 9.1: Input numbers from the keyboard into an array and
// output the array's numbers to a text file

import java.io.*;
import java.util.Scanner;

public class ArrayToFile{

   public static void main(String[] args) throws IOException {
      // Set up scanner and array
      Scanner reader = new Scanner(System.in);
      int[] array = new int[10];
      int count = 0;

      // Input numbers until full or user enters -1
      while (count < array.length){
         System.out.print("Enter a number (-1 to quit): ");
         int number = reader.nextInt();
         if (number == -1)
            break;
         array[count] = number;
         count++;
      }

      // Output the numbers to a text file
      PrintWriter writer = new PrintWriter(new File("numbers.txt"));
      for (int i = 0; i < count; i++)
         writer.println(array[i]);
      writer.close();
   }
}