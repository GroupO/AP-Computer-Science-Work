// Example 15.5: A LinkedList implementation of a queue

import java.util.*;

public class TrueLinkedQueue<E> implements TrueQueue<E>{

   protected LinkedList<E> list;

   public TrueLinkedQueue(){
      list = new LinkedList<E>();
   }

   public boolean add(E element){
      list.addFirst(element);
      return true;
   }

   public boolean isEmpty(){
      return list.isEmpty();
   }

   public E peek(){
      if (list.isEmpty())
         return null;
      return list.getLast();
   }

   public E remove(){
      if (list.isEmpty())
         throw new NoSuchElementException();
      return list.removeLast();
   }

   public int size(){
      return list.size();
   }
}
