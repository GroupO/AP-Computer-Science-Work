/* Example 12.1: TowersOfHanoi.java
Print the moves required to move the rings in the Towers of Hanoi problem.
1) Enter the number of rings as input.
2) WARNING: Do not run this program with 64 rings.
*/

import java.util.Scanner;

public class TowersOfHanoi{

   public static void main(String [] args){
   //  Obtain the number of rings from the user.
   //  Call the recursive move method to move the rings from peg 1 to peg 3
   //  with peg 2 available for intermediate usage.
   //  Preconditions  -- number of rings != 64  
   //  Postconditions -- the moves are printed in the terminal window

      Scanner reader = new Scanner(System.in);  
      System.out.print("Enter the number of rings: ");
      int numberOfRings = reader.nextInt(); 
      move (numberOfRings, 1, 3, 2);
   }
   
   private static void move(int n, int i, int j, int k){
   //  Print the moves for n rings going from peg i to peg j
   //  Preconditions  -- none
   //  Postconditions -- the moves have been printed
   
      if (n > 0){                //Stopping state is n == 0
      
         //Move the n-1 smaller rings from peg i to peg k
         move(n - 1, i, k, j); 
         
         //Move the largest ring from peg i to peg j             
         System.out.println("Move ring " + n + " from peg " + i + " to " + j);
         
         //Move the n-1 smaller rings from peg k to peg j
         move(n - 1, k, j, i);
         
         //n rings have now been moved from peg i to peg j
      }
   }
}


