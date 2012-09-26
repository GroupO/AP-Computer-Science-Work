/* Example 12.2: ManyQueens.java
Determine the solution to the Many Queens problem for a chessboard
of any size.
1) There is a single input indicating the size of the board.
2) If there is a solution display it, else indicate that there is none.
*/

import java.util.Scanner;

public class ManyQueens {
   public static void main (String [] args) {
   // Process the user's input. Call a recursive function
   // to determine if there is a solution. Print the results.
   //  Preconditions  -- the input is an integer greater
   //                    than or equal to 1
   //  Postconditions -- display a solution or a message stating that there
   //                    is none
      int boardSize;           //The size of the board, for instance, 8 would
                                      //indicate an 8x8 board
      boolean[][] board;   //A two-dimensional array representing the board
                                      //An entry of false indicates that a square is
                                     //unoccupied
      //Initialize the variables
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter the board size: ");
      boardSize = reader.nextInt();
      board = new boolean[boardSize][boardSize];
      for (int row = 0; row < boardSize; row++)
         for (int col = 0; col < boardSize; col++)
            board[row][col] = false;
      //Determine if there is a solution
      if (! canPlaceQueen (0, board))
         //There is no solution
         System.out.println ("Impossible on a board of size " +
                              boardSize + "x" + boardSize);
      else{
         //There is a solution, so print it
         System.out.println ("Here is a solution for a board of size " +
                              boardSize + "x" + boardSize);
         for (int row = 0; row < boardSize; row++){
            for (int col = 0; col < boardSize; col++){
               if (board[row][col])
                  System.out.print ("Q");
               else
                  System.out.print ("-");
            }
            System.out.println();
         }
      } 
   }
   private static boolean canPlaceQueen (int col, boolean[][] board){
   // Mark as true the first unattacked location in column col that
   // permits a solution across the remaining columns.
   //  Preconditions  -- 0 <= col < board.length
   //  Postconditions -- if an entry in col gets marked true
   //                    return true else return false
      for (int row = 0; row < board.length; row++){ // Iterate down the column
         if (! attacked (row, col, board)){         // if square is not under attack
            if (col == board.length -1){            // if this is the last column
               board[row][col] = true;              // end recursion, set square true
               return true;                         // recursive ascent true
             }else{                                 // else
               board[row][col] = true;              // trial solution, set square true
                                                    // if recursive descent succeeds
               if (canPlaceQueen (col + 1, board))
                  return true;                      // recursive ascent true
               else                                 // else
                  board[row][col] = false;          // trial solution didn't work
             }                                      // end if
         }                                          // end if
      }
      return false;                                 //recursive ascent false
   }
   private static boolean attacked (int row, int col, boolean [][] board){
  // Determine if the square at location (row, col) is under attack.
  // from any queen in columns 0 to col - 1
  //  Preconditions  -- 0 <= row, col < board.length
  //  Postconditions -- returns true if square under attack else false
  //Look for horizontal attack
      int i, j, k;
      for (j = 0; j < col; j++){
         if (board[row][j])
            return true;
      }
      //Look for attack from a descending diagonal
      i = row - 1;
      j = col - 1;
      for (k = 0; k <= Math.min(i, j); k++){
         if (board[i][j])
            return true;
         else{
            i--;
            j--;
         }
      }
      //Look for attack from an ascending diagonal
      i = row + 1;
      j = col - 1;
      for (k = 0; k <= Math.min(board.length - i - 1, j); k++){
         if (board[i][j])
            return true;
         else{
            i++;
            j--;
         }
      }
      return false;
   }
}
