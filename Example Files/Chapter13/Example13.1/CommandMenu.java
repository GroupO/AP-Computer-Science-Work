import java.util.ArrayList;
import java.util.Scanner;

public class CommandMenu extends Command{

   private ArrayList<Command> menu;
   private Scanner reader;

   public CommandMenu(String title, Scanner s){
      super(title);
      menu = new ArrayList<Command>();
      reader = s;
   }

   // Adds a command option to the menu
   public void add(Command c){
      menu.add(c);
   }

   // Removes all menu options
   public void clear(){
      menu.clear();
   }

   // Main loop for the menu
   public boolean run(){
      boolean continuing = true;
      while (continuing){
         displayMenu();
         int input = readCommand(1, menu.size() + 1);
         if (input == menu.size() + 1)
            break;
         continuing = menu.get(input - 1).run();
      }
      return true;
   }

   // Displays the menu's title
   // Prepends numbers to items and adds an exit option
   // before displaying them
   private void displayMenu(){
      System.out.println(toString());
      for (int i = 0; i < menu.size(); i++)
         System.out.println((i + 1) + ": " + menu.get(i));
      System.out.println((menu.size() + 1) + ": Exit this menu");
   }

   // Robust input of command numbers
   private int readCommand(int low, int high){
      System.out.print("Enter a number from " + low + 
                       " to " + high + ": ");
      try{
         int input = reader.nextInt();
         if (input < low || input > high){
            System.out.println("The number must be between " + 
                               low + " and " + high);
            return readCommand(low, high);
         }else
            return input;
      }catch(Exception e){
            System.out.println("Input must be a number");
            return readCommand(low, high);
      }
   }
}

   
      
      