/**
 * Author:  Arthur Lockman
 * Date:    Dec 2, 2012
 * School:  Gorham High School
 * 
 * Project: Week13 String Exercises
 * Package: com.rthr.cs
 */
package com.rthr.cs;

/**
 * A class containing all of the week 13 string exercises.
 * @author arthurlockman
 */
public class StringExercises
{

	/**
	 * Performs all of the string exercises.
	 * @param args
	 */
	public static void main(String[] args)
	{
		StringExercises exercises = new StringExercises();
		exercises.doExercise1();
		exercises.doExercise2();
		exercises.doExercise3();
		exercises.doExercise4();
		exercises.doExercise5();

	}
	
	/**
	 * @brief Use the following declarations to create a new string 
	 * variable that contains the phrase "going to Win" and print to the screen. 
	 * 			String word = "Washington";
	 */
	public void doExercise1()
	{
		this.beginExercise(1);
		
		String word = "going to Win";
		System.out.println(word);
		
		this.endExercise(1);
	}
	
	/**
	 * @brief Using the original string value for word create a new string 
	 * named backwards that contains the reverse of the original 
	 * string in word and print to the screen.
	 */
	public void doExercise2()
	{
		this.beginExercise(2);
		
		String word = "Washington";
		StringBuffer wordBuffer = new StringBuffer(word);
		
		String backwards = wordBuffer.reverse().toString();
		
		System.out.println(backwards);
		
		this.endExercise(2);
	}
	
	/**
	 * @brief Given the following declarations :   String phrase =  
	 * " WazzUp ? - Who's On FIRST ??? - IDUNNO";   Write the 
	 * necessary code to count the number of vowels in the string 
	 * and print appropriate message to the screen.
	 */
	public void doExercise3()
	{
		this.beginExercise(3);
		
		String phrase =  "WazzUp ? - Who's On FIRST ??? - IDUNNO";
		char[] phraseArray = phrase.toCharArray();
		int count = 0;
		
		for (int i = 0; i < phraseArray.length; i++)
		{
			if (phraseArray[i] == 'a' || phraseArray[i] == 'e' 
					|| phraseArray[i] == 'i' || phraseArray[i] == 'o' 
					|| phraseArray[i] == 'u' || phraseArray[i] == 'y' 
					|| phraseArray[i] == 'A' || phraseArray[i] == 'E' 
					|| phraseArray[i] == 'I' || phraseArray[i] == 'O' 
					|| phraseArray[i] == 'U' || phraseArray[i] == 'Y')
				count++;
		}
		
		System.out.println("This string contains "+count+" vowels.");
		
		this.endExercise(3);
	}
	
	/**
	 * @brief Search the string "George Washington" for the substrings 
	 * "ton" and "Wish". Print an appropriate message to the screen.
	 */
	public void doExercise4()
	{
		this.beginExercise(4);
		
		String name = "George Washington";
		
		System.out.println("Searching string 'George Washington' for 'Wish' and 'ton'.");

		if (name.indexOf("ton") != -1)
			System.out.println("Found string 'ton'.");
		else
			System.out.println("String 'ton' not found.");
		
		if (name.indexOf("Wish") != -1)
			System.out.println("Found string 'Wish'.");
		else
			System.out.println("String 'wish' not found.");
		
		this.endExercise(4);
	}
	
	/**
	 * @brief Given the following assignment to word 
	 * String word = "We the people of the United States in order to form a more perfect union" 
	 * Write a method that will find and print the last word in the string.
	 */
	public void doExercise5()
	{
		this.beginExercise(5);
		
		String word = "We the people of the United States in order to form a more perfect union";
		String[] wordSplit = word.split(" ");
		
		System.out.println("The last word in the string is "+wordSplit[wordSplit.length-1]+".");
		
		this.endExercise(5);
	}
	
	/**
	 * Print init information for the exercise.
	 * @param exerciseNumber The exercise about to be performed.
	 */
	private void beginExercise(int exerciseNumber)
	{
		System.out.println("Beginning Exercise "+exerciseNumber);
		System.out.println("--------------------\n");
	}
	
	/**
	 * Print end information for the exercise.
	 * @param exerciseNumber The exercise just completed.
	 */
	private void endExercise(int exerciseNumber)
	{
		System.out.println("\n-----------------");
		System.out.println("Ending Exercise "+exerciseNumber+"\n");
	}

}
