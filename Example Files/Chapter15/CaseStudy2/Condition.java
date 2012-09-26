// Case Study 15.2: The Condition class
// Implements generic Comparable

public class Condition implements Comparable<Condition>{

   static public final Condition critical = new Condition(1, "critical");   
   static public final Condition serious  = new Condition(2, "serious");   
   static public final Condition fair     = new Condition(3, "fair");   

   private int order;
   private String name;

   private Condition(int ord, String nm){
      name = nm;
      order = ord;
   }

   public int compareTo(Condition other){
      return order - other.order;
   }

   public String toString(){
      return name;
   }
}