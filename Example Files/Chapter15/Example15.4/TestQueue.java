// Example 15.4: Tests a queue as a LinkedList

import java.util.*;

public class TestQueue{

   public static void main(String[] args){
      // Create a queue and add some strings
      Queue<String> queue = new LinkedList<String>();
      queue.add("First");
      queue.add("Second");
      System.out.println(queue.peek());    // Prints "First"
      System.out.println(queue.remove());  // Prints "First"
   }
}
