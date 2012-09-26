// Case Study 1: Evaluator of postfix expressions
// Model class

import java.util.*;

public class Evaluator{

   public String run(String input){
      Stack<String> stack = new Stack<String>();
      StringTokenizer tokens = new StringTokenizer(input);
      String operand1 = null, operand2 = null;
      String error = null;
      while (tokens.hasMoreTokens() && error == null){
         String token = tokens.nextToken();
         if (isOperand(token))
            stack.push(token);
         else if (isOperator(token)){
            if (! stack.empty()){
               operand2 = stack.pop();
               if (! stack.empty()){
                  operand1 = stack.pop();
                  String result = computeValue(operand1, token, operand2);
                  if (result != null)
                     stack.push(result);
                  else
                     error = "Attempt to divide by 0";
               }else
                  error = "Malformed expression";
            }else
               error = "Malformed expression";
         }else
            error = "Malformed expression";
      }
      if (stack.size() != 1)
         error = "Malformed expression";
      if (error != null)
         return error;
      else
         return stack.pop();
   }

   private boolean isOperand(String s){
      for (int i = 0; i < s.length(); i++)
         if (! Character.isDigit(s.charAt(i)))
            return false;
      return true;
   }

   private boolean isOperator(String s){
      return s.equals("+") ||
             s.equals("-") ||
             s.equals("*") ||
             s.equals("/");
  }

   private String computeValue(String op1, String op, String op2){
      int result = 0;
      int intOp1 = Integer.parseInt(op1);
      int intOp2 = Integer.parseInt(op2);
      if (op.equals("+"))
         result = intOp1 + intOp2;
      else if (op.equals("-"))
         result = intOp1 - intOp2;
      else if (op.equals("*"))
         result = intOp1 * intOp2;
      else if (op.equals("/"))
         if (intOp2 == 0)
            return null;
         else
            result = intOp1 / intOp2;
      return "" + result;
   }
}

