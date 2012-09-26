// Example 19.1: The interface for the binary search tree prototypes

import java.util.List;

public interface BSTPT<E extends Comparable<E>> extends Iterable<E>{

   public E add(E element);
   public E contains(E element);
   public boolean isEmpty();
   public E remove(E element);
   public int size();
   public String toString();
   public List<E> inorderTraverse();
   public List<E> levelorderTraverse();
   public List<E> postorderTraverse();
   public List<E> preorderTraverse();
}
