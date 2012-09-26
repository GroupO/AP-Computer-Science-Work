public class TestMap{

   public static void main(String [] args){

      MapPT map = new HashMapPT();

      for (int i = 1; i <= 10; i++)
         map.put("Key " + i, "Value " + i);
         
      System.out.println(map);
   }
}
