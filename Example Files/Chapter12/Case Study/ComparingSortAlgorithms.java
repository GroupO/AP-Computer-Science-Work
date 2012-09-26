// Case Study 12.1: Compare two sort algorithms

import java.util.*;

public class ComparingSortAlgorithms {

   public static void main(String[] args){  
      Random gen = new Random();
      Scanner reader = new Scanner(System.in);
      while(true){
         System.out.print("Enter the array Length [0 to quit]: ");
         int arrayLength = reader.nextInt();
         if (arrayLength <= 0)
            break; 
         // Instantiate two arrays,
         // one of this length and the other a 100 times longer.
         int[] a1 = new int[arrayLength];
         int[] a2 = new int[arrayLength * 100];
      
         //Initialize the first array
         for (int i = 0; i < a1.length; i++)
            a1[i] = gen.nextInt(100001);
            // Random numbers between 0 and 100,000
      
         //Initialize the second array
         for (int i = 0; i < a2.length; i++)
            a2[i] = gen.nextInt(100001);
      
         //Time bubble sort
         Date d1 = new Date();
         bubbleSort (a1);
         Date d2 = new Date();
         long elapsedTime1 = d2.getTime() - d1.getTime();
      
         //Time quicksort
         d1 = new Date();
         quickSort (a2, 0, a2.length - 1);
         d2 = new Date();
         long elapsedTime2 = (d2.getTime() - d1.getTime());
      
         //Display results in pretty format 
         System.out.printf("       %12s %14s%n", "Bubble Sort",  "QuickSort");
         System.out.printf("Length %8d %16d%n",   arrayLength,  arrayLength * 100);
         System.out.printf("Time   %8d %16d%n%n", elapsedTime1, elapsedTime2);
      } 
   }

   private static void bubbleSort (int[] a){
      for (int i = 0; i < a.length - 1; i++){
         for (int j = i + 1; j < a.length; j++){
            if (a[i] > a[j]){
               int temp = a[i];
               a[i] = a[j];
               a[j] = temp;
            }
         }
      }
   }
   
   private static void quickSort (int[] a, int left, int right){
      if (left >= right) return;
      int i = left;
      int j = right;
      int pivotValue = a[(left + right)/2];  // Pivot is at midpoint
      while (i < j){
         while (a[i] < pivotValue) i++;
         while (pivotValue < a[j]) j--;
         if (i <= j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
         }
      }
      quickSort (a, left, j);
      quickSort (a, i, right);
   }   
            
}
