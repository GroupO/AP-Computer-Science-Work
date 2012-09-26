// Example 19.3: A tester program for priority queues

import java.util.Iterator;

public class TestPriorityQueue{

   public static void main(String[] args){
      TrueQueue<String> q = new HeapPriorityQueue<String>();

      System.out.println("Adding D B A C F E G");
      q.add("D");
      q.add("B");
      q.add("A");
      q.add("C");
      q.add("F");
      q.add("E");
      q.add("G");

      System.out.println("\nRemoving: ");
      while (q.size() > 0)
         System.out.print(q.remove() + " ");
   }

}
