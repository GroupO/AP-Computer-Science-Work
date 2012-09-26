// Example 19.3: The heap implementation of a priority queue

import java.util.*;

public class HeapPriorityQueue<E extends Comparable<E>> implements TrueQueue<E>{
    
   private HeapPT<E> heap;     // A heap of items

   public HeapPriorityQueue(){
      heap = new ArrayHeapPT<E>();
   }

   public boolean add(E element){
      heap.add(element);
      return true;
   }
    
   public boolean isEmpty(){
      return size() == 0;
   }
   
   public Iterator<E> iterator(){
      return heap.iterator();
   }
    
   public E peek(){
      if (size() == 0)
         return null;
      return heap.peek();
   }

   public E remove(){
      if (size() == 0)
         throw new NoSuchElementException();
      return heap.pop();
   }

   public int size(){
      return heap.size();
   }
}
