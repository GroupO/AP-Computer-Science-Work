// Example 15.7: A restricted implementation of a priority queue based
// on a true linked queue

// Variable inherited from TrueLinkedQueue: list (a LinkedList)
// Methods  inherited from TrueLinkedQueue: isEmpty, peek, remove, and size

import java.util.*;

public class TrueLinkedPriorityQueue<E extends Comparable<E>> extends TrueLinkedQueue<E>{

   public TrueLinkedPriorityQueue(){
      super();
   }

   public boolean add(E element){
      int position = 0;
      while (position < list.size() && element.compareTo(list.get(position)) < 0)
         position++;
      list.add(position, element);
      return true; 
   }
}
