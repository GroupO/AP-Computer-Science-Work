public class TestSet{

   public static void main(String [] args){

      SetPT set = new HashSetPT();

      for (int i = 1; i <= 10; i++)
         set.add("Item " + i);

      System.out.println(set);

   }
}
