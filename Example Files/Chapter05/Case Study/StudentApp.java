// Case Study 5.1

import java.util.Scanner;

public class StudentApp{

   public static void main(String[] args){
      // Instantiate the students and the keyboard object
      Student student1 = new Student();
      Student student2 = new Student();
      Scanner reader = new Scanner(System.in);

      String name;
      int score;

      // Input the first student's data
      System.out.print("Enter the first student's name: ");
      name = reader.nextLine();
      student1.setName(name);
      for (int i = 1; i <= 3; i++){
         System.out.print("Enter the student's score: ");
         score = reader.nextInt();
         student1.setScore(i, score);
      }
      // Consume the trailing newline character
      reader.nextLine();

      // Input the second student's data
      System.out.print("Enter the second student's name: ");
      name = reader.nextLine();
      student2.setName(name);
      for (int i = 1; i <= 3; i++){
         System.out.print("Enter the student's score: ");
         score = reader.nextInt();
         student2.setScore(i, score);
      }

      // Output the two students' information
      System.out.println(student1);
      System.out.println(student2);

      // Output the student with the highest score
      if (student1.getHighScore() > student2.getHighScore()){
         name = student1.getName();
         score = student1.getHighScore();
      }else{
         name = student2.getName();
         score = student2.getHighScore();
      }
      System.out.println(name + " has the highest score: " + score);
      
      // Output the student with the highest average score
      if (student1.getAverage() > student2.getAverage()){
         name = student1.getName();
         score = student1.getAverage();
      }else{
         name = student2.getName();
         score = student2.getAverage();
      }
      System.out.println(name + " has the highest average score: " + score);
   }
}

