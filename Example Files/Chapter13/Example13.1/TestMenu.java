// Example 13.1: Tester program for menu-driven command interface
// Tests basic menu options and nested menus

import java.util.Scanner;

public class TestMenu{

   public static void main(String[] args){
      new TestMenu();
   }

   public TestMenu(){
      // Create the scanner for all the menus
      Scanner reader = new Scanner(System.in);
      // Create the main menu
      CommandMenu mainMenu = new CommandMenu("Main Menu", reader);
      // Create and add an About option
      Command c0 = new AboutCommand();
      mainMenu.add(c0);
      // Create a File menu, its options, and add them to that menu
      CommandMenu fileMenu = new CommandMenu("File Menu", reader);
      Command c1 = new OpenCommand();
      Command c2 = new SaveCommand();
      fileMenu.add(c1);
      fileMenu.add(c2);
      // Create an Edit menu, its options, and add them to that menu
      CommandMenu editMenu = new CommandMenu("Edit Menu", reader);
      Command c3 = new CutCommand();
      Command c4 = new PasteCommand();
      Command c5 = new JumpCommand();
      editMenu.add(c3);
      editMenu.add(c4);
      editMenu.add(c5);
      // Add the File and Edit menus to the main menu
      mainMenu.add(fileMenu);
      mainMenu.add(editMenu);
      // Run the main menu to accept commands
      mainMenu.run();
   }

   // Private classes for the basic menu options

   private class OpenCommand extends Command{

      private OpenCommand(){
         super("Open");
      }

      public boolean run(){
         System.out.println("Running open . . .");
         return true;
      }
   }

   private class SaveCommand extends Command{

      private SaveCommand(){
         super("Save");
      }

      public boolean run(){
         System.out.println("Running save . . .");
         return true;
      }
   }

   private class CutCommand extends Command{

      private CutCommand(){
         super("Cut");
      }

      public boolean run(){
         System.out.println("Running cut . . .");
         return true;
      }
   }

   private class PasteCommand extends Command{

      private PasteCommand(){
         super("Paste");
      }

      public boolean run(){
         System.out.println("Running paste . . .");
         return true;
      }
   }

   // This command will exit its caller's menu
   private class JumpCommand extends Command{

      private JumpCommand(){
         super("Jump to Main");
      }

      public boolean run(){
         System.out.println("Jumping to Main . . .");
         return false;
      }
   }

   private class AboutCommand extends Command{

      private AboutCommand(){
         super("About");
      }

      public boolean run(){
         System.out.println("Running about . . .");
         return true;
      }
   }

}