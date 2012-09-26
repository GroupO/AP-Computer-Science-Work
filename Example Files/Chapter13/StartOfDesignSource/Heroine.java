public class Heroine extends Entity{
   private Place place;
   private int lives;

   public Heroine(String nm, String desc, int strngth){
      super(nm, desc, strngth);
      lives = 9;
   }

   public Place getPlace(){
      return place;
   }

   public String move(String pathName){
      if (lives == 0)
         return "The hero is out of lives and cannot move.";
      else{
         Place newPlace = place.getDestination(pathName);
         place = newPlace;
         return "";
      }
   }

   public void startAt(Place plc){
      place = plc;
   }
}
