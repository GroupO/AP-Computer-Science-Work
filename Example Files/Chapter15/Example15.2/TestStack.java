// Example 15.2: Tests an Arraystack

import java.util.*;

public class TestStack{

   public static void main(String[] args){
      // Create a list and add some strings
      List<String> lst = new ArrayList<String>();
      for (int i = 0; i <= 5; i++)
         lst.add("String " + i);

       // Create a stack and transfer the strings
      TrueArrayStack<String> stk = new TrueArrayStack<String>(); 
      for (String str : lst)
         stk.push(str);

      // Pop and display objects from the stack
      while (! stk.empty())                       
         System.out.println(stk.pop());

      // Cause an EmptyStackException
      stk.pop();
   }
}
