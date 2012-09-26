// Example 9.3: Testing the enhanced for loop

public class TestForLoop{

   public static void main(String[] args){

      // Sum the elements in a one-dimensional array
      int[] abc = {2, 3, 4};
      int sum = 0;
      for (int element : abc)
         sum += element;
      System.out.println("First sum: " + sum);

      // Sum the elements in a two-dimensional array 
      int[][] table = {{2, 3, 4}, {2, 3, 4}, {2, 3, 4}};
      sum = 0;
      for (int[]row : table)    
         for (int element : row) 
            sum += element;
      System.out.println("Second sum: " + sum);
   }
}
