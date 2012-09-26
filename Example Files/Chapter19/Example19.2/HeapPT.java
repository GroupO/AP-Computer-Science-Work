// Example 19.2: The interface for the heap prototype

public interface HeapPT<E extends Comparable<E>> extends Iterable<E>{

   public boolean add(E element);
   public E peek();
   public E pop();
   public int size();
}
