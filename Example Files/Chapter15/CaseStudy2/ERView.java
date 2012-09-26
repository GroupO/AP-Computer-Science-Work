// Case Study 15.2: The ERView class

import java.util.Scanner;

public class ERView{

   private ERModel model = new ERModel();

   public ERView(){
      Scanner reader = new Scanner(System.in);
      int command = 1;
      String menu = "1. Schedule a patient\n" +
                    "2. Treat the next patient\n" +
                    "3. Treat all patients\n" +
                    "4. Exit the program\n";
      while (command != 4){
         command = getCommand(1, 4, menu);
         if (command == 1)
            schedule();
         else if (command == 2)
            treatNext();
         else if (command == 3)
            treatAll();
      }
   }

   private void schedule(){
      Scanner reader = new Scanner(System.in);
      System.out.print("Enter the patient's name: ");
      String name = reader.nextLine();
      Condition condition = getCondition();
      model.schedule(new Patient(name, condition));
      System.out.println(name + " is added to the " +
                         condition + " list\n");
   }

   private void treatNext(){
      Patient patient = model.treatNext();
      if (patient == null)
         System.out.println("No patients available to treat");
      else
         System.out.println(patient + " is being treated");
   }

   private void treatAll(){
      Patient patient = model.treatNext();
      if (patient == null){
         System.out.println("No patients available to treat");
         return;
      }
      while (patient != null){
         System.out.println(patient + " is being treated");
         patient = model.treatNext();
      }
   }

   private Condition getCondition(){
      String menu = "CONDITION\n" +
                    "1. Critical\n" +
                    "2. Serious\n" +
                    "3. Fair\n";
      int i = getCommand(1, 3, menu);
      if (i == 1)
         return Condition.critical;
      else if (i == 2)
         return Condition.serious;
      else
         return Condition.fair;
   }

   private int getCommand(int low, int high, String menu){
      Scanner reader = new Scanner(System.in); 
      int number = 0;
      System.out.print(menu);
      System.out.print("Enter a number [" + low + "-" + 
                                           high + "]: ");
      try{
         number = reader.nextInt();
         if (number < low || number > high){
            System.out.println("Number must be >= " + low + 
                               " and <= " + high);
            return getCommand(low, high, menu);
         }
         else
            return number;
      }catch(Exception e){
         System.out.println("You must enter a number");
         return getCommand(low, high, menu);
      }
   }
}
