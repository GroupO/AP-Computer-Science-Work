/**
 * Author:  Arthur Lockman, Siddharth Mangali, Nicholas Sammut, 
 * 			Mitchell Derby, Gabriel Phelan, and Dylan Anderson.
 * Date:    Jan 30, 2013
 * School:  Virtual High School
 * 
 * Project: Week19 Group Project
 * Package: com.cs
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author arthurlockman
 *
 */
public class TestGrader
{	
	/**
	 * The main method. 
	 * @param args System flags (none). 
	 */
	public static void main(String[] args)
	{
		TestGrader grader = new TestGrader();
		grader.run();
	}
	
	/**
	 * @brief Runs the test grader. 
	 */
	public void run()
	{
		String[] rawScores = this.getScores("data.txt");
		String[] processedScores = Arrays.copyOfRange(rawScores, 1, rawScores.length);
		char[] key = rawScores[0].toCharArray();
		char[] letterScores = new char[processedScores.length];
		int[] numberScores = new int[processedScores.length];
		Student[] students = new Student[processedScores.length];
		
		for (int i = 0; i < processedScores.length; i++)
		{
			students[i] = this.gradeQuiz(processedScores[i], key);
			numberScores[i] = students[i].getScore(1);
			letterScores[i] = this.convertToLetterGrade(students[i].getScore(1));
		}
		
		int[] distribution = this.getScoreFrequencies(letterScores);
		
		this.printScores(selectionSort(students), numberScores, letterScores, distribution);
		this.printScores(bubbleSort(students), numberScores, letterScores, distribution);
		this.printC(students);
	}
	
	/**
	 * @brief Grades a quiz.
	 * @param scoreAndID A string, the score and student ID as
	 * fetched by the getScores method.
	 * @return The score of the student, and their ID. ID is array[0], 
	 * score is array[1].
	 */
	private Student gradeQuiz(String scoreAndID, char[] key)
	{
		String id = scoreAndID.split(" ")[0];
		char[] test = scoreAndID.split(" ")[1].toCharArray();
		int score = 10;
		
		for (int i = 0; i < test.length; i++)
		{
			if (key[i] != test[i])
				score--;
		}
		
		Student ret = new Student(id, 1);
		ret.setScore(1, score);
		return ret;
	}
	
	/**
	 * @brief Converts a numerical score into a letter grade.
	 * @param score The numerical score, from 0-10.
	 * @return A char, the letter grade (A, B, C, D, F).
	 */
	private char convertToLetterGrade(int score)
	{
		switch (score)
		{
			case 10: return 'A'; 
			case 9: return 'B'; 
			case 8: return 'C';
			case 7: return 'C';
			case 6: return 'D';
			case 5: return 'D';
			default: return 'F';
		}
	}
	
	/**
	 * @brief Prints the scores of the students in the class, the
	 * number of students, and the class average.
	 * @param students The student ID's of the class' students.
	 * @param numberScores The numerical scores of the students quizzes.
	 * @param letterScores The letter scores of the students quizzes. 
	 * @param distribution The distribution of scores.
	 */
	private void printScores(Student[] students, int[] numberScores, char[] letterScores, int[] distribution)
	{
		System.out.println("-----Class Data-----");
		System.out.println("Total students: "+(students.length));
		System.out.println("Class average: " + this.average(numberScores) + 
				" (" + this.convertToLetterGrade(this.average(numberScores))+")");
		System.out.println("Score Distribution: A - " + distribution[0] + " | B - " 
				+ distribution[1] + " | C - " + distribution[2] + " | D - " + distribution[3] 
				+ " | F - " + distribution[4]);
		System.out.println("\n-----Student Data (Sorted by ID)-----");
		System.out.println(" ID | Score | Letter |");
		System.out.println("-------------------------------------");
		for (int i = 0; i < students.length; i++)
		{
			System.out.println(students[i].getName() + "    " + students[i].getScore(1) + "       " + this.convertToLetterGrade(students[i].getScore(1)));
		}
	}
	
	/**
	 * @brief Takes the average of an array of integers.
	 * @param numbers
	 * @return
	 */
	private int average(int[] numbers)
	{
		int tot = 0;
		for (int i = 0; i < numbers.length; i++)
			tot += numbers[i];
		
		return tot / numbers.length;
	}
	
	/**
	 * @brief Finds the frequencies of each of the quiz scores.
	 * @param scores The letter scores to calculate the frequienies
	 * from.
	 * @return A int[], index 0 = number of A's, 1 = B, 2 = C, 3 = D, 
	 * 4 = F.
	 */
	private int[] getScoreFrequencies(char[] scores)
	{
		int[] distribution = new int[5];
		for (int i = 0; i < scores.length; i++)
		{
			switch (scores[i])
			{
				case 'A': distribution[0]++; break;
				case 'B': distribution[1]++; break;
				case 'C': distribution[2]++; break;
				case 'D': distribution[3]++; break;
				case 'F': distribution[4]++; break;
			}
		}
		return distribution;
	}
	
	/**
	 * @brief Sorts the student list based on ID number.
	 * @param list the list of students.
	 * @return The sorted list.
	 */
	private Student[] selectionSort(Student[] list)
	{
		for (int i = 0; i < list.length - 1; i++)
		{
			int minIndex = findMin(list, i);
			if (minIndex != i)
				swap(list, i, minIndex);
		}
		return list;
	}
	
	private int findMin(Student[] list, int first)
	{
		int minIndex = first;
		for (int i = first + 1; i < list.length; i++)
		{
			if (!list[i].compareID(list[minIndex]))
				minIndex = i;
		}
		return minIndex;
	}
	
	void swap (Student[] a, int x, int y)
	{
		Student temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	private Student[] bubbleSort(Student[] a)
	{
		int k = 0;
		boolean exchangeMade = true;
		
		while ((k < a.length - 1) && exchangeMade)
		{
			exchangeMade = false;
			k++;
			for (int j = 0; j < a.length - k; j++)
			{
				if (!a[j].compareScores(a[j+1]))
				{
					swap (a, j, j+1);
					exchangeMade = true;
				}
			}
		}
		return a;
	}
	
	private void printC(Student[] a)
	{
		System.out.println();
		for (int i = 0; i < a.length; i++)
		{
			if (this.convertToLetterGrade(a[i].getScore(1)) == 'C')
				System.out.println("Student "+a[i].getName()+" received a C.");
		}
	}
	
	/**
	 * @brief Reads in the project data file from a path relative
	 * to the class itself.
	 * @param dataFileName The name of the data file.
	 * @return The parsed data, answer key is array[0].
	 */
	private String[] getScores(String dataFileName)
	{
		InputStream fIn = getClass().getResourceAsStream(dataFileName);
		BufferedReader fReader = new BufferedReader(new InputStreamReader(fIn));
		
		// Using an array list allows this to handle data files of any size.
		ArrayList<String> scores = new ArrayList<String>();
		String line = null;
		
		try
		{	
			while ((line = fReader.readLine()) != null)
			{
				scores.add(line);
			}
			
			fReader.close();
			fIn.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		String[] scoresArray = new String[scores.size()];
		scores.toArray(scoresArray);
		return scoresArray;
	}

}
