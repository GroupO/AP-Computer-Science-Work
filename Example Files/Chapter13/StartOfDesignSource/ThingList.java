/*
  This class provides some utility functions for working with
  lists of things.
*/

import java.util.*;

public class ThingList {

   public static NamedThing getThing(String thingName, List things){
      NamedThing namedThing = null;
      for (int i = 0; i < things.size(); i++){
         namedThing = (NamedThing)things.get(i);
         if (namedThing.name.equals(thingName)) break;
      }
      return namedThing;
   }

   public static String[] getThingNames(List things){
      String[] thingNames = new String[things.size()];
      for (int i = 0; i < things.size(); i++)
         thingNames[i] = ((NamedThing)things.get(i)).getName();
      return thingNames;
   }

   public static NamedThing removeThing(String thingName, List things){
      NamedThing namedThing = null;
      for (int i = 0; i < things.size(); i++){
         namedThing = (NamedThing)things.get(i);
         if (namedThing.name.equals(thingName)) break;
      }
      if (namedThing == null) return null;
      things.remove(namedThing);
      return namedThing;
   }

   public static String toString(List things){
      String str = "";
      for (int i = 0; i < things.size(); i++){
         Object obj = things.get(i);
         str += "\n" + obj.toString();
      }
      return str;
   }
}