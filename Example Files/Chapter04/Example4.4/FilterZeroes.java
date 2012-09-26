// Example 4.4: Inputs a text file of integers and writes these
// to an output file without the zeroes

import java.io.*;
import java.util.Scanner;

 public class FilterZeroes{
   public static void main(String[] args) throws IOException {

      // Open the scanner and print writer
      Scanner reader = new Scanner(new File("numbers.txt"));
      PrintWriter writer = new PrintWriter(new File("newnumbers.txt"));

      // Read the numbers and write all but the zeroes
      while (reader.hasNext()){
         int number = reader.nextInt(); 
         if (number != 0)
            writer.println(number);
      }

      // Remember to close the output file
      writer.close();
   }
}
