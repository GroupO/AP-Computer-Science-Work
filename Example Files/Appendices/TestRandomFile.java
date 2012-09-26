/* Example H2: Test random access files
*/

import java.io.*;

public class TestRandomFile{

   private int[] testArray = {23, 46, 67};

   public static void main(String[] args){
      TestRandomFile app = new TestRandomFile();
   }

   public TestRandomFile(){
      arrayToFile(testArray);
      sequentialTraverse();
      testInput();
   }

   public void arrayToFile(int[] array){
      try{
         RandomAccessFile output = new RandomAccessFile("test", "rw");
         for (int i = 0; i < array.length; i++){
            output.seek(i * 4);
            output.writeInt(array[i]);   
         }
         output.close();
      }catch(Exception e){}
   }

   public void testInput(){
      try{
         RandomAccessFile input = new RandomAccessFile("test", "r");
         int numberOfInts = (int)(input.length() / 4); // Get number of ints
         int midpoint = numberOfInts / 2 * 4;          // Get position of middle int
         input.seek(midpoint);                         // Move directly to midpoint
         int item = input.readInt();                   // read the int
         System.out.println("Number of ints = " + numberOfInts);
         System.out.println("Midpoint       = " + midpoint);
         System.out.println("Middle int     = " + item);
         input.close();
      }catch(Exception e){}
   }


   // Sequential traversal using indices
   void sequentialTraverse(){
      try{
         RandomAccessFile input = new RandomAccessFile("test", "r");
         long numberOfItems = input.length() / 4;
         for (long i = 0; i <= numberOfItems; i++){
            input.seek(i * 4);
            System.out.println(i + ": " + input.readInt()); 
         }
         input.close();
      }catch(Exception e){}
   }

}



