public class Path extends NamedThing{
   private Place destination;

   public Path(String nm, String desc, Place dest){
      super(nm, desc);
      destination = dest;
   }

   public Place getDestination(){
      return destination;
   }
}

