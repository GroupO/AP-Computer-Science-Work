// Example 18.3: HashSetPT

import java.util.Iterator;

public class HashSetPT implements SetPT{

   private static final int DEFAULT_CAPACITY = 3; 
                               // Purposely set to a small value in order
                               // to ensure collisions
           
   // Temporary variables
   private Entry foundEntry;  // entry just located
                              // undefined if not found
   private Entry priorEntry;  // entry prior to one just located
                              // undefined if not found
   private int   index;       // index of chain in which entry located
                              // undefined if not found
                                    
   // Instance variables
   private int   capacity;    // size of table[]
   private Entry table[];     // the table of collision lists
   private int   size;        // number of entries in the map
    
   public HashSetPT(){
      capacity = DEFAULT_CAPACITY;
      clear();
   }    public boolean add(Object item){
      if (!contains (item)){ 
         Entry newEntry = new Entry (item, table[index]);
         table[index] = newEntry;
         size++;
         return true;
      }else
         return false;
   }

   public void clear(){
      size = 0;
      table = new Entry[capacity];
   }

   public boolean contains (Object item){
      index = Math.abs(item.hashCode()) % capacity;
      priorEntry = null;
      foundEntry = table[index];
      while (foundEntry != null){
         if (foundEntry.item.equals (item)) 
            return true;
         else{
            priorEntry = foundEntry;
            foundEntry = foundEntry.next;
         }
      }
      return false;
   }

   public boolean isEmpty(){
     return size == 0;
   }

   public Iterator iterator(){
      // Project 18-6 Ð must create an inner class as well
      return null;
   }
    
   public boolean remove(Object item){
      if (!contains (item))
         return false;
      else{
         if (priorEntry == null)
            table[index] = foundEntry.next;
         else
            priorEntry.next = foundEntry.next;
         size--; 
         return true;
      }
   }
    
   public int size(){
      return size;
   }
   
   public String toString(){
      String rowStr;
      String str = "HashSetPT: capacity = " +  capacity  
                 + " load factor = " + ((double)size() / capacity); 
      for (int i = 0; i < table.length; i++){
         rowStr = "";
         for (Entry entry = table[i]; entry != null; entry = entry.next) 
            rowStr += entry + " "; 
         if (rowStr != "")
            str += "\nRow " + i + ": " + rowStr;
      }
      return str;       
   } 

   private class Entry {

      private Object item;      //Item for this entry
      private Entry  next;      //Reference to next entry
    
      private Entry(){
         this(null, null);
      }

      private Entry(Object item, Entry next){
         this.item = item;
         this.next = next;
      }

      public String toString(){
         return "" + item;
      }
   }
}
