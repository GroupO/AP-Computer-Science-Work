// Case Study 1: Evaluator of postfix expressions
// View class

import java.util.Scanner;

public class EvaluatorView{

   public static void main (String[] args){
      Scanner reader = new Scanner(System.in);
      Evaluator evaluator = new Evaluator();
      String query = "Y";
      while (query.equalsIgnoreCase("Y")){
         System.out.print("Enter a postfix expression: ");
         String input = reader.nextLine();
         String output = evaluator.run(input);
         System.out.println(output);
         System.out.print("Evaluate another expression[y/n]: ");
         query = reader.nextLine();
      }
   }
}

