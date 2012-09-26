// Example 15.3: Tests a StringTokenizer

import java.util.StringTokenizer;

public class TestTokenizer{

   public static void main(String[] args){
      String sentence = "Four score and seven years ago, our fathers set " +
                        "forth on this continent a new nation.";
  
      StringTokenizer tokens = new StringTokenizer(sentence);

      while (tokens.hasMoreTokens())
          System.out.println (tokens.nextToken());
   }
}
