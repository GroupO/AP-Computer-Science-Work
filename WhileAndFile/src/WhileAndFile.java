//  While loops and File input

import java.io.*;
import java.util.StringTokenizer;

public class WhileAndFile 
{
  private static FileInputStream inFile;
  private static InputStreamReader inReader;
  private static  BufferedReader reader;
  private static StringTokenizer strTkn;
  private static String line,word;
  private static int num1, num2,num3,grade, total;
  private static double avg;
  
  public static void main (String args[]) throws IOException
  {
    initFile();  
    getData();
    inFile.close();
  }
 
 // preparing the file for input
 
  public static void initFile() throws IOException
  {
    inFile = new FileInputStream ("/Users/arthurlockman/Dropbox/School/AP CS/Work/Data Files/test2.txt/");
    inReader = new InputStreamReader(inFile);
    reader = new BufferedReader(inReader);
  }
  
  
  
  public static void getData() throws IOException
  {
     line = reader.readLine();  //Seeding the while condition.  Variable line
                                // must either hold a valid string 
                                //  or an empty (null) string;
    while(line != null)
    {
      strTkn = new StringTokenizer(line); 
      word = strTkn.nextToken();
      grade = Integer.parseInt(strTkn.nextToken());
      num1 = Integer.parseInt(strTkn.nextToken());
      num2 = Integer.parseInt(strTkn.nextToken());
      num3 = Integer.parseInt(strTkn.nextToken());
      calcAvg();     // calls to processing and printing methods
      printCalcs();
      line = reader.readLine();   // IMPORTANT updating of the while condition
                                  // by acquiring a new line of information
    }
  }  
    
   // processing the average
  public static void calcAvg()
  {
    total = num1 + num2 + num3;
    avg = (double) total / 3;   //  IMPORTANT ... casting the int total to a
                                // double to assure a decimal average
  }  

    // output results

  public static void printCalcs()
  {

    System.out.print(word+ " " + grade + " " + num1 + "  " + num2+ "  ");
    System.out.println (num3 + "  "  + avg);
  }    
} // end of class 
 