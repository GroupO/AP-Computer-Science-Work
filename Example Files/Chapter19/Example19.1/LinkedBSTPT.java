// Example 19.1: The linked implementation of 
// the binary search tree prototype (unfinished version)

import java.util.*;

public class LinkedBSTPT<E extends Comparable<E>> implements BSTPT<E>{

   private Node<E> root;
   private int size;

   public LinkedBSTPT(){
      root = null;
      size = 0;
   }

   public String toString(){
      return toString(root, 0);
   }

   private String toString(Node<E> tree, int level){
      String str = "";
      if (tree != null){
         str += toString(tree.right, level + 1);
         for (int i = 1; i <= level; ++i)
            str = str + "| ";
         str += tree.value.toString() + "\n";
         str += toString(tree.left, level + 1);
      }
	    return str;
   }

   public E add(E element){
      Node<E> newNode = new Node<E>(element);

      // Tree is empty, so item goes at the root
      if (root == null){
         root = newNode;
         size++;
         return null;
      }
 
      // Search for the item's spot or a duplicate
      else{
         Node<E> probe = root;
         while (probe != null){
            int relation = element.compareTo(probe.value);

            // A duplicate is found, so replace it and return it
            if (relation == 0){
               E oldvalue = probe.value;
               probe.value = element;
               return oldvalue;
            }

            // New item is less, so go left until spot is found
            else if (relation < 0)
               if (probe.left != null)
                  probe = probe.left;
               else{
                  probe.left = newNode;
                  size++;
                  return null;
               }

            // New item is greater, so go right until spot is found
            else if (probe.right != null)
            probe = probe.right;
            else{
               probe.right = newNode;
               size++;
               return null;
            }
         }
         return null;   // Never reached
      }
   }       

   public E contains(E element){
      return contains(root, element);
   }

   public int size(){
      return size;
   }

   public boolean isEmpty(){
      return size() == 0;
    }

   private E contains(Node<E> tree, E element){
      if (tree == null)
         return null;
      else{
         int relation = element.compareTo(tree.value);
         if (relation == 0)
            return tree.value;
         else if (relation < 0)
            return contains(tree.left, element);
         else
            return contains(tree.right, element);
      }
   }

   public Iterator<E> iterator(){
      return inorderTraverse().iterator();
   }

   public List<E> inorderTraverse(){
      List<E> list = new ArrayList<E>();
      inorderTraverse(root, list);
      return list;
   }

   private void inorderTraverse(Node<E> tree, List<E> list){
      if (tree != null){
         inorderTraverse(tree.left, list);
         list.add(tree.value);
         inorderTraverse(tree.right, list);
      }
   }

   public List<E> postorderTraverse(){
      List<E> list = new ArrayList<E>();
      postorderTraverse(root, list);
      return list;
   }

   private void postorderTraverse(Node<E> tree, List<E> list){
      // Exercise
   }

   public List<E> preorderTraverse(){
      List<E> list = new ArrayList<E>();
      preorderTraverse(root, list);
      return list;
   }

   private void preorderTraverse(Node<E> tree, List<E> list){
      // Exercise
   }

   public List<E> levelorderTraverse(){
      List<E> list = new LinkedList<E>();
      Queue<Node<E>> levelsQu = new LinkedList<Node <E>>();
      if (root != null){
         levelsQu.add(root);
         levelorderTraverse(levelsQu, list);
      }
      return list;
   }

   private void levelorderTraverse(Queue<Node<E>> levelsQu, List<E> list){
      // Exercise
   }

   public E remove (E element){
      // Exercise
      return element;
    }
      
   private class Node<E>{

      private E value;
      private Node<E> left, right;

      private Node(E v){
         this(null, v, null);
      }

      private Node(Node<E> l, E v, Node<E> r){
         left = l;
         value = v;
         right = r;
      }
   }
}

