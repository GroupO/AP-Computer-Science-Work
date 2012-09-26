// Example 19.2: The array implementation of the heap prototype

import java.util.*;

public class ArrayHeapPT<E extends Comparable<E>> implements HeapPT<E>{

   private List<E> heap;  // The "array"

   public ArrayHeapPT(){
      heap = new ArrayList<E>();
   }

   public int size(){
      return heap.size();
   }

   public boolean add (E element){
      int curPos, parent;
        
      heap.add(element);
      curPos = heap.size() - 1;
      while (curPos > 0){
         parent = (curPos - 1) / 2;
         E parentItem = heap.get(parent);
         if (parentItem.compareTo(element) <= 0)
            return true;
         else{
            heap.set(curPos, heap.get(parent));
            heap.set(parent, element);
            curPos = parent;
         }
      }
      return true;
   } 

   public E peek(){
      if (size() == 0)
         throw new NoSuchElementException
              ("Trying to peek at an empty heap");
      return heap.get(0);
   }

   public E pop(){
      if (size() == 0)
         throw new NoSuchElementException
              ("Trying to remove from an empty heap");

      int curPos, leftChild, rightChild, maxChild, lastIndex;
      E topItem = heap.get(0);
      E bottomItem = heap.remove(heap.size() - 1);
      if (heap.size() == 0)
         return bottomItem;
           
      heap.set(0, bottomItem);
      lastIndex = heap.size() - 1;
      curPos = 0;
      while (true){
         leftChild = 2 * curPos + 1 ;
         rightChild = 2 * curPos + 2;
         if (leftChild > lastIndex) break;
         if (rightChild > lastIndex)
            maxChild = leftChild;
         else{
            E leftItem  = heap.get(leftChild);
            E rightItem = heap.get(rightChild);
            if (leftItem.compareTo (rightItem) < 0)
               maxChild = leftChild;
            else
               maxChild = rightChild;
         }
         E maxItem = heap.get(maxChild);
         if (bottomItem.compareTo (maxItem) <= 0)
            break;
         else{
            heap.set(curPos, heap.get(maxChild));
            heap.set(maxChild, bottomItem);
            curPos = maxChild;
         }
      }
      return topItem;
   }

   public Iterator<E> iterator(){
      return heapToList().iterator();
   }

   private List<E> heapToList(){
      List<E> tempList = new ArrayList<E>(heap);
      List<E> resultList = new ArrayList<E>();
      while (heap.size() > 0)
         resultList.add(pop());
      heap = tempList;
      return resultList;
   }

   public String toString(){
      return toString(0, 0);
   }

   private String toString(int position, int level){
      String str = "";
      if (position < heap.size()){
         str += toString(2 * position + 2, level + 1);
         for (int i = 1; i <= level; i++)
            str = str + "| ";
         str += heap.get(position) + "\n";
         str += toString(2 * position + 1, level + 1);
      }
      return str;
   }   
}

