// Example 15.2: Interface for a restricted stack

public interface TrueStack<E>{

   public boolean empty();
   
   public E peek();

   public E pop();

   public void push(E element);

   public int size();
}
