// Example 16.1: Displays a file’s words and their frequencies

import java.io.*;
import java.util.*;

public class WordFrequencies{

   public static void main (String[] args) throws IOException{
      Scanner reader = new Scanner(System.in);
      String query = "y";
      while (query.equalsIgnoreCase("y")){
         // Read the words from a file into a list
         System.out.print("Enter a file name: ");
         String fileName = reader.nextLine();
         Scanner fileReader = new Scanner(new File(fileName));
         List<String> wordList = new ArrayList<String>();
         while (fileReader.hasNext()){
            String word = fileReader.next();
            wordList.add(word.toUpperCase());
         }
         // Copy the words from the list to a sorted set
         SortedSet<String> wordSet = new TreeSet<String>();
         for (String word : wordList)
            wordSet.add(word);
         // Print each unique word and its frequency in columns
         for (String word : wordSet){
            int frequency = occurrencesOf(wordList, word);
            System.out.printf("%-30s%5d%n", word, frequency);
         }

         System.out.print("Analyze another file?[y/n]: ");
         query = reader.nextLine();
      }
   }

   private static int occurrencesOf(List<String> list, String word){
      int total = 0;
      for (String s : list)
         if (s.equals(word))
            total++;
      return total;      
   }
}
