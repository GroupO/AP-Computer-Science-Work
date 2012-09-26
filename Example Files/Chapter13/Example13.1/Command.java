// Represents a command
// Contains a menu item and requires a run() method

abstract public class Command{

   private String title;

   public Command(String s){
      title = s;
   }

   public String toString(){
      return title;
   }

   abstract public boolean run();
}