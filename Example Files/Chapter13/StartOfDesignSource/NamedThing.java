abstract public class NamedThing{
   protected String name;
   protected String description;

   public NamedThing(String n, String d){
      name = n;
      description = d;
   }

   public String getName(){
      return name;
   }

   public String toString(){
      return name + ": " + description;
   }
}

