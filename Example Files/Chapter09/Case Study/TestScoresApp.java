// Case Study 9.1: The main application class

public class TestScoresApp{

   public static void main(String[] args){
      TestScoresModel model = new TestScoresModel();
      new TestScoresView(model);
   }
}