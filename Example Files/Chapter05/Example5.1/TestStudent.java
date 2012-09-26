// Example 5.1: Tester program for Student class

public class TestStudent{

   public static void main(String[] args){
      Student s1, s2;

      s1 = new Student();    // Instantiate a student object
      s1.setName("Bill");    // Set the student's name to "Bill"
      s1.setScore(1,84);     // Set the score on test 1 to 84
      s1.setScore(2,86);     //               on test 2 to 86
      s1.setScore(3,88);     //               on test 3 to 88
      System.out.println("\nHere is student s1\n" + s1);
      
      s2 = s1;               // s1 and s2 now refer to the same object 
      s2.setName("Ann");     // Set the name through s2
      System.out.println ("\nName of s1 is now: " + s1.getName());
   }
}

