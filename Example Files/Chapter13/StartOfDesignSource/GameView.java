// Menu-driven, terminal-based user interface for Balbor program
// Start of design version

import java.util.Scanner;

public class GameView{

   // Menus and lists of paths, entities, and place items
   private CommandMenu mainMenu, fileMenu, paths, entities, placesItems;

   // The keyboard for all menus
   private Scanner reader;

   // The model
   private GameWorld gameWorld;

//---------------------- Constructor

   public GameView(){
      // Create the scanner for all the menus
      reader = new Scanner(System.in);

      // Create the main menu
      mainMenu = new CommandMenu("Main Menu", reader);

      // Create a File menu, its option, and add it to that menu
      fileMenu = new CommandMenu("File Menu", reader);
      fileMenu.add(new OpenCommand());

      // Create menus for the lists
      paths       = new CommandMenu("Paths", reader);
      entities    = new CommandMenu("Entities", reader);
      placesItems = new CommandMenu("Place Items", reader);

      // Add the file menu and lists to the main menu
      mainMenu.add(fileMenu);
      mainMenu.add(paths);
      mainMenu.add(entities);
      mainMenu.add(placesItems);

      // Instantiate the game world
      gameWorld = new GameWorld();

      // Announce the program and start the main menu
      System.out.println("The Treasures of Balbor");
      mainMenu.run();
   }

  // Commands for menus

   private class OpenCommand extends Command{
  
      private OpenCommand(){
         super("Open");
      }

      public boolean run(){
         gameWorld.createHardCodedWorld();
         updateAllControls();
         return false;
      }
   }

   private class PathDisplayCommand extends Command{
  
      private PathDisplayCommand(String pathName){
         super(pathName);
      }

      public boolean run(){
         String str = gameWorld.getPathString(toString());
         System.out.println(str);
         return true;
      }
   }

   private class PathMoveCommand extends Command{
  
      private PathMoveCommand(String pathName){
         super(pathName);
      }

      public boolean run(){
         String errorMessage = gameWorld.move(toString());
         if (! errorMessage.equals("")){
            System.out.println(errorMessage);
            return true;
         }
         else{
            updateAllControls();
            return false;
         }
      }
   }

   // Helper methods

   // Displays a description of the current place
   // and updates the lists with the info relating to
   // that place
   private void updateAllControls(){
      // Update place description
      String str = gameWorld.getPlaceString();
      System.out.println(str);

      // Update lists
      updatePaths(paths, gameWorld.getPathNames());
      updateList(entities, gameWorld.getEntityNames());
      updateList(placesItems, gameWorld.getPlaceItemNames());
   }

   // Resets the paths list to the paths out of the current place 
   private void updatePaths(CommandMenu paths, String[] names){
      paths.clear();
      for (String name : names){
         CommandMenu menu = new CommandMenu(name, reader);
         menu.add(new PathDisplayCommand("Display " + name));
         menu.add(new PathMoveCommand("Move to " + name));
         paths.add(menu);
      }
   }

   // Resets the items in a command menu 
   private void updateList(CommandMenu list, String[] names){
      list.clear();
      for (String name : names){
         CommandMenu menu = new CommandMenu(name, reader);
         list.add(menu);
      }
   }

}
