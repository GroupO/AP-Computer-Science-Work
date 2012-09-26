// Case Study: View for the therapist program

import java.util.Scanner;

public class TherapistView{

   private Therapist therapist = new Therapist();
   
   public TherapistView(){
      Scanner reader = new Scanner(System.in);
      System.out.println("Good day. What is your problem?");
      while (true){
         System.out.print("\nEnter your response here: ");
         String patientString = reader.nextLine();
         String therapistString = therapist.reply(patientString);
         System.out.println("\n" + therapistString);
      }
   }
}
