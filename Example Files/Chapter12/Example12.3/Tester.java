// Example 12.3: Test fibonacci method

public class Tester{

   private static int count = 0;

   public static void main (String[] args){
      for (int i = 1; i <= 5; i++){
         count = 0;
         int n = (int)Math.pow(2, i);
         int fibn = fibonacci(n);
         System.out.println ("" + n + ":" + count);
      }
   }

   private static int fibonacci (int n){
      count++;
      if (n <= 2)
         return 1;
      else
         return fibonacci(n - 1) + fibonacci(n - 2);
   }
}
