// Example 15.2: ArrayList implementation of a restricted stack

import java.util.*;

public class TrueArrayStack<E> implements TrueStack<E>{

   private List<E> list;

   public TrueArrayStack(){
      list = new ArrayList<E>();
   }

   public boolean empty(){
      return list.isEmpty();
   }
   
   public E peek(){
      if (empty())
         throw new EmptyStackException();
      return list.get(list.size() - 1);
   }

   public E pop(){
      if (empty())
         throw new EmptyStackException();
      return list.remove(list.size() - 1);
   }

   public void push(E element){
      list.add(element);
   }

   public int size(){
      return list.size();
   }
}
