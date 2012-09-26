// Example 19.1: A tester program for the binary search tree prototypes

import java.util.*;

public class TestBST{

   public static void main(String[] args){

      BSTPT<String> tree = new LinkedBSTPT<String>();

      System.out.println("Adding D B A C F E G");
      tree.add("D");
      tree.add("B");
      tree.add("A");
      tree.add("C");
      tree.add("F");
      tree.add("E");
      tree.add("G");

      System.out.println("ToString:\n" + tree);

      System.out.print("Iterator (inorder traversal): ");
      Iterator<String> iter = tree.iterator();
      while (iter.hasNext())
         System.out.print(iter.next() + " ");

      // Use a for loop instead
      System.out.print("\nfor loop (inorder traversal): ");
      for (String s : tree)
         System.out.print(s + " ");

      System.out.print("\nPreorder traversal: ");
      List<String> list = tree.preorderTraverse();
      printList(list);
      
      System.out.print("\nPostorder traversal: ");
      list = tree.postorderTraverse();
      printList(list);

      System.out.print("\nLevel order traversal: ");
      list = tree.levelorderTraverse();
      printList(list);

      System.out.print("\nRemovals: ");
      for (char ch = 'A'; ch <= 'G'; ch++)
         System.out.print(tree.remove("" + ch) + " ");
   }

   private static <E> void printList(List<E> list){
      for (E element : list)
         System.out.print(element + " ");
   }
}
