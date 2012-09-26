// Case Study 15.2: The Patient class

public class Patient implements Comparable<Patient>{

   private String name;
   private Condition condition;

   public Patient(String n, Condition c){
      name = n;
      condition = c;
   }

   public int compareTo(Patient other){
      return condition.compareTo(other.condition);
   }

   public String toString(){
      return name + " / " + condition;
   }
}
