import java.util.Scanner;

public class CircleArea{

   static public void main(String[] args){
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter the radius: ");
      double radius = reader.nextDouble();
      if (radius < 0)
         System.out.println("Error: Radius must be >= 0");
      else{
         double area = Math.PI * Math.pow(radius, 2);
         System.out.println("The area is " + area);
      }
   }
}
