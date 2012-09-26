// Example 15.5: Tests a restricted linked queue

import java.util.*;

public class TestQueue{

   public static void main(String[] args){
      // Create a list and add some strings
      List<String> lst = new ArrayList<String>();
      for (int i = 0; i <= 5; i++)
         lst.add("String " + i);

       // Create a stack and transfer the strings
      TrueQueue<String> que = new TrueLinkedQueue<String>(); 
      for (String str : lst)
         que.add(str);

      // Remove and display objects from the queue
      while (! que.isEmpty())                       
         System.out.println(que.remove());

      // Cause an NoSuchElementException
      que.remove();
   }
}
