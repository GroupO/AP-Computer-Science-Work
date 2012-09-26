public class GameWorld{
   private Heroine hero;

   public void createHardCodedWorld(){
      Place entrance
        = new Place("Castle Entrance",
        "You are standing in front of a drawbridge.");
      Place courtyard
        = new Place("Courtyard",
        "Horses' hooves ring against rough cobbles.");
      Place stables
        = new Place("Stables",
        "Twenty horse stalls line the walls.");
      Place greatHall
        = new Place("Great Hall",
        "You are in a richly furnished hall.");
      Place dungeon
        = new Place("Dungeon",
        "Groans of the oppressed fill the air.");
      Place turret
        = new Place("Turret",
        "You are looking out over the castle's lands.");
      Place well
        = new Place("Well",
        "You have fallen into a deep, slippery well. \nThere is no way out.");

      hero
        = new Heroine("Sue",
        "Our strong and worthy hero, who never say no" +
        "\nto a rousing adventure.", 10);
      hero.startAt(entrance);
      Foe aarf = new Foe("Aarf", "Fierce hound.", 10);
      Foe hagarth = new Foe("Hagarth", "A very giant of a giant.", 10);
      Foe superMonster = new Foe("Super Monster", "Too big to kill.", 10000000);

      entrance.addItem(new Treasure("Ring", "Large gold ring.", 10));
      courtyard.addItem(new Treasure ("Bucket", "Magic bucket, never empty.", 10));
      courtyard.addItem(new Weapon("Staff", "Stout oak staff.", 10));
      greatHall.addItem(new Treasure ("Purse", "Magic purse, never empty.", 10));
      greatHall.addItem(new Weapon("Sword", "Thrice forged blade.", 10));
      greatHall.addFoe(aarf);
      greatHall.addFoe(hagarth);
      dungeon.addFoe(superMonster);
      hero.addItem(new Weapon("Spear", "Long pokey spear.", 10));
      hero.addItem(new Treasure("Ruby", "As large as a plover's egg.", 10));
      aarf.addItem(new Weapon("Collar", "Leather collar studded with spikes.", 10));
      hagarth.addItem(new Weapon("Club", "Shaped from a tree trunk.", 10));
      hagarth.addItem(new Treasure("Belt", "Gold belt with diamond buckle.", 10));
      hagarth.addItem(new Weapon("Dagger", "As large as a small sword.", 10));

      entrance.addPath
        (new Path("Drawbridge",
        "Rotting planks and rusting chains do not a good bridge make.",
        courtyard));
      courtyard.addPath
        (new Path("Drawbridge",
        "Rotting planks and rusting chains do not a good bridge make.",
        entrance));

      courtyard.addPath
        (new Path("South",
        "Careful where you step.",
        stables));
      stables.addPath
        (new Path("North",
        "Careful where you step.",
        courtyard));

      courtyard.addPath
        (new Path("Great Doors",
        "Push hard. The doors are immense.",
        greatHall));
      greatHall.addPath
        (new Path("Great Doors",
        "Pull hard. The doors are immense.",
        courtyard));

      greatHall.addPath
        (new Path("Stairs Up",
        "A winding staircase leads up into the darkness.",
         turret));
      turret.addPath
        (new Path("Stairs Down",
        "A winding staircase leads down into the darkness.",
        greatHall));

      greatHall.addPath
        (new Path("Stairs Down",
        "A winding staircase leads down into the darkness.",
        dungeon));
      dungeon.addPath
        (new Path("Stairs Up",
        "A winding staircase leads up into the darkness.",
        greatHall));

      greatHall.addPath
        (new Path("Secret Door",
        "This door looks little used.",
        well));
   }

   public String[] getEntityNames(){
      String[] foeNames = hero.getPlace().getFoeNames();
      String[] allNames = new String[foeNames.length + 1];
      allNames[0] = hero.getName();
      for (int i = 0; i < foeNames.length; i++)
         allNames[i + 1] = foeNames[i];
      return allNames;
   }

   public String[] getPlaceItemNames(){
      return hero.getPlace().getItemNames();
   }

   public String[] getPathNames(){
      return hero.getPlace().getPathNames();
   }

   public String getPathString(String pathName){
      return hero.getPlace().getPath(pathName).toString();
   }

   public String getPlaceString(){
      if (hero == null)
         return "You must open a game file first.";
      else
         return hero.getPlace().toString();
   }

   public String move(String pathName){
      return hero.move(pathName);
   }
}
