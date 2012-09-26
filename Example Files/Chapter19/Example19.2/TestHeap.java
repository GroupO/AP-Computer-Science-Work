// Example 19.2: A tester program for the heap prototype

import java.util.Iterator;

public class TestHeap{

   public static void main(String[] args){

      HeapPT<String> heap = new ArrayHeapPT<String>();

      System.out.println("Adding D B A C F E G");
      heap.add("D");
      heap.add("B");
      heap.add("A");
      heap.add("C");
      heap.add("F");
      heap.add("E");
      heap.add("G");

      System.out.println("toString: ");
      System.out.println(heap);    

      System.out.println("Iterating with iterator: ");
      Iterator<String> iter = heap.iterator();
      while (iter.hasNext())
         System.out.print(iter.next() + " ");

      System.out.println("\nIterating with for loop: ");
      for (String s : heap)
         System.out.print(s + " ");

      System.out.println("\nPopping: ");
      while (heap.size() > 0)
         System.out.print(heap.pop() + " ");
   }

}
