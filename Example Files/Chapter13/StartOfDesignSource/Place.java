import java.util.ArrayList;

public class Place extends NamedThing{
   private ArrayList<Path> paths;
   private ArrayList<Item> items;
   private ArrayList<Foe> foes;

   public Place(String n, String d){
      super(n, d);
      paths = new ArrayList<Path>();
      items = new ArrayList<Item>();
      foes = new ArrayList<Foe>();
   }

   public void addFoe(Foe foe){
      foes.add(foe);
   }

   public void addItem(Item item){
      items.add(item);
   }

   public void addPath(Path path){
      paths.add(path);
   }

   public Place getDestination(String pathName){
      Path namedPath = getPath(pathName);
      return namedPath.getDestination();
   }

   public String[] getFoeNames(){
      return ThingList.getThingNames(foes);
   }

   public String[] getItemNames(){
      return ThingList.getThingNames(items);
   }

   public Path getPath(String pathName){
      for (Path namedPath : paths)
         if (namedPath.name.equals(pathName)) 
            return namedPath;
      return null;
   }

   public String[] getPathNames(){
      return ThingList.getThingNames(paths);
   }
}



