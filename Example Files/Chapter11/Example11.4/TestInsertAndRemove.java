// Example 11.4: Test insertions and removals

public class TestInsertAndRemove{
   
   public static void main(String[] args){

      // Create an initial array with 3 positions
      String[] array = new String[3];          
      int logicalSize = 0;
      boolean successful = false;

      // Insert strings at positions 0, 1, 1, and 0
      successful = insertItem(array, logicalSize, 0, "Jack");
      if (successful)
         logicalSize++;  
      successful = insertItem(array, logicalSize, 1, "Jill");
      if (successful)
         logicalSize++;  

      successful = insertItem(array, logicalSize, 1, "sees");
      if (successful)
         logicalSize++;  

      successful = insertItem(array, logicalSize, 0, "Before");
      if (successful)
         logicalSize++;  

      // Display new logical size and contents
      System.out.println(logicalSize);                  
      for (int i = 0; i < logicalSize; i++) 
         System.out.print(array[i] + " ");
   }

   // Definitions of array methods go here
   private static boolean insertItem(Object[] array, int logicalSize, 
                                     int targetIndex, Object newItem){
      // Check for a full array and return false if full
      if (logicalSize == array.length)
         return false;

      // Check for valid target index and return false if not valid
      if (targetIndex < 0 || targetIndex > logicalSize)
         return false;

      // Shift items down by one position
      for (int i = logicalSize; i > targetIndex; i--)      
         array[i] = array[i - 1];

      // Add new item and return true                       
      array[targetIndex] = newItem;
      return true;

   }

   private static boolean removeItem(Object[] array, int logicalSize, 
                                     int targetIndex){
      // Check for valid target index and return false if not valid
      if (targetIndex < 0 || targetIndex >= logicalSize)
         return false;

      // Shift items up by one position
      for (int i = targetIndex; i < logicalSize - 1; i++)       
         array[i] = array[i + 1];

      // Return true 
      return true;                                   
   }

}
