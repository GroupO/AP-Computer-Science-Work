// Case Study 15.2: The Patient class

import java.util.PriorityQueue;

public class ERModel{

   private PriorityQueue<Patient> patients;

   public ERModel(){
      patients = new PriorityQueue<Patient>();
   }

   public void schedule(Patient p){
      patients.add(p);
   }

   public Patient treatNext(){
      if (patients.size() == 0)
         return null;
      else
         return patients.remove();
   }
}
