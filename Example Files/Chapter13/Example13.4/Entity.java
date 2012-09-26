import java.util.ArrayList;

abstract public class Entity extends NamedThing{
   protected int strength;
   protected ArrayList<Item> items;

   public Entity(String nm, String desc, int strngth){
      super(nm, desc);
      strength = strngth;
      items = new ArrayList<Item>();
   }

   public void addItem(Item item){
      items.add(item);
   }
}
