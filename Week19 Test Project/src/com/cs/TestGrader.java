/**
 * Author:  Arthur Lockman, Siddharth Mangali, Nicholas Sammut, 
 * 			Mitchell Derby, Gabriel Phelan, and Dylan Anderson.
 * Date:    Jan 30, 2013
 * School:  Virtual High School
 * 
 * Project: Week19 Group Project
 * Package: com.cs
 */
package com.cs;

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
		int[] numberScores = new int[processedScores.length];
		char[] letterScores = new char[processedScores.length];
		int[] students = new int[processedScores.length];
		
		for (int i = 0; i < processedScores.length; i++)
		{
			numberScores[i] = this.gradeQuiz(processedScores[i], key)[1];
			students[i] = this.gradeQuiz(processedScores[i], key)[0];
			letterScores[i] = this.convertToLetterGrade(numberScores[i]);
		}
		
		int[] distribution = this.getScoreFrequencies(letterScores);
		
		this.printScores(students, numberScores, letterScores, distribution);
	}
	
	/**
	 * @brief Grades a quiz.
	 * @param scoreAndID A string, the score and student ID as
	 * fetched by the getScores method.
	 * @return The score of the student, and their ID. ID is array[0], 
	 * score is array[1].
	 */
	private int[] gradeQuiz(String scoreAndID, char[] key)
	{
		int id = Integer.parseInt(scoreAndID.split(" ")[0]);
		char[] test = scoreAndID.split(" ")[1].toCharArray();
		int score = 10;
		
		for (int i = 0; i < test.length; i++)
		{
			if (key[i] != test[i])
				score--;
		}
		
		int[] ret = new int[2];
		ret[0] = id;
		ret[1] = score;
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
	private void printScores(int[] students, int[] numberScores, char[] letterScores, int[] distribution)
	{
		System.out.println("-----Class Data-----");
		System.out.println("Total students: "+(students.length));
		System.out.println("Class average: " + this.average(numberScores) + 
				" (" + this.convertToLetterGrade(this.average(numberScores))+")");
		System.out.println("Score Distribution: A - " + distribution[0] + " | B - " 
				+ distribution[1] + " | C - " + distribution[2] + " | D - " + distribution[3] 
				+ " | F - " + distribution[4]);
		System.out.println("\n-----Student Data-----");
		System.out.println(" ID | Score | Letter |");
		System.out.println("----------------------");
		for (int i = 0; i < students.length; i++)
		{
			System.out.println(students[i] + "    " + numberScores[i] + "       " + letterScores[i]);
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
