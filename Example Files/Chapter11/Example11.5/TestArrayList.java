// Example 11.5: Test an array list of integers

import java.util.ArrayList;

public class TestArrayList{

   public static void main(String[] args){

      // Create a list of Integers
      ArrayList<Integer> list = new ArrayList<Integer>(); 

      // Add the ints 1-100 to the list   
      for (int i = 1; i <= 100; i++)           
         list.add(i);

      // Increment each int in the list
      for (int i = 0; i < list.size(); i++)      
         list.set(i, list.get(i) + 1);

      // Display the contents of the list
      for (int i : list)
         System.out.println(i);
   }
}
