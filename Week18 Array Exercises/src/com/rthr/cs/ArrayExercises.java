/**
 * Author:  Arthur Lockman
 * Date:    Jan 27, 2013
 * School:  Gorham High School
 * 
 * Project: Week18 Array Exercises
 * Package: com.rthr.cs
 */
package com.rthr.cs;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * @author arthurlockman
 *
 */
public class ArrayExercises
{

	/**
	 * @brief Performs the week 18 string exercises. 
	 * @param args Program arguments.
	 */
	public static void main(String[] args)
	{
		ArrayExercises self = new ArrayExercises();
		
		self.doExercise1(self.generateRandomDoubleArray(5));
		self.doExercise2(self.generateRandomIntArray(10));
		self.doExercise3(self.generateRandomArray(5, 4));
	}
	
	/**
	 * @brief Takes an array of ten doubles, and prints their average.
	 * @param arr The array of doubles.
	 */
	public void doExercise1(double[] arr)
	{
		this.beginExercise(1);
		
		double sum = 0;
		for (int i =0; i< arr.length; i++)
		{
			sum += arr[i];
		}
		
		double average = sum / arr.length;
		
		System.out.println("The average of the array is "+average+".");
		System.out.print("The numbers ");
		for (int i =0; i< arr.length; i++)
		{
			if (arr[i] > average)
				System.out.print(arr[i]+", ");
		}
		System.out.print("are greater than the average.");
		System.out.println();
		this.endExercise(1);
	}
	
	/**
	 * @brief Finds and prints the mode of an array of ints.
	 * @param arr The array of ints.
	 */
	public void doExercise2(int[] arr)
	{
		this.beginExercise(2);
	    
		int maxValue, maxCount;
		maxCount = 0;
		maxValue = 0;

	    for (int i = 0; i < arr.length; ++i) 
	    {
	        int count = 0;
	        for (int j = 0; j < arr.length; ++j) 
	        {
	            if (arr[j] == arr[i]) ++count;
	        }
	        if (count > maxCount) 
	        {
	            maxCount = count;
	            maxValue = arr[i];
	        }
	    }

	    System.out.println("The mode of the array is "+maxValue+".");
		this.endExercise(2);
	}
	
	/**
	 * @brief The program should output the 2-D array, 
	 * the sum of each row storing numbers in a 
	 * parallel array and the sum of each column 
	 * storing number in a parallel array.   
	 * @param arr The 2D array of random ints.
	 */
	public void doExercise3(int[][] arr)
	{
		this.beginExercise(3);
		
		this.print2DArray(arr);
		this.sumRows(arr);
		this.sumColumns(arr);
		
		this.endExercise(3);
	}
	
	/**
	 * @brief Returns an array of random numbers.
	 * @param rows The number of rows in the array.
	 * @param columns The number of columns.
	 * @return The array, populated with random integers. 
	 */
	private int[][] generateRandomArray(int rows, int columns)
	{
		int[][] array = new int[rows][columns];
		Random rand = new Random(102535);
		
		for (int c = 0; c < array.length; c++)
		{
			for (int r = 0; r < array[c].length; r++)
			{
				array[c][r] = rand.nextInt(10)+1;
			}
		}
		
		return array;
	}
	
	/**
	 * @brief Returns an array of random doubles.
	 * @param rows The number of rows in the array.
	 * @param columns The number of columns.
	 * @return The array, populated with random integers. 
	 */
	private double[] generateRandomDoubleArray(int elements)
	{
		double[] array = new double[elements];
		Random rand = new Random(9001);
		DecimalFormat df = new DecimalFormat("0.##");
		
		for (int c = 0; c < array.length; c++)
		{
			array[c] = Double.parseDouble(df.format(rand.nextDouble()))*10;
		}
		
		return array;
	}
	
	/**
	 * @brief Returns an array of random ints.
	 * @param rows The number of rows in the array.
	 * @param columns The number of columns.
	 * @return The array, populated with random integers. 
	 */
	private int[] generateRandomIntArray(int elements)
	{
		int[] array = new int[elements];
		Random rand = new Random(902301);
		
		for (int c = 0; c < array.length; c++)
		{
			array[c] = rand.nextInt(10);
		}
		
		return array;
	}
	
	/**
	 * Prints a 2D array of integers.
	 * @param arr A two dimensional array of integers.
	 */
	private void print2DArray(int[][] arr)
	{
		for (int c = 0; c < arr.length; c++)
		{
			for (int r = 0; r < arr[c].length; r++)
			{
				System.out.print(arr[c][r] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
	
	/**
	 * @brief Prints the sum of each row in a 2D array.
	 * @param arr The array.
	 */
	private void sumRows(int[][] arr)
	{
		for (int c = 0; c < arr.length; c++)
		{
			int sum = 0;
			for (int r = 0; r < arr[c].length; r++)
			{
				sum += arr[c][r];
			}
			System.out.println("The sum of row "+(c+1)+" is "+sum+".");
		}
		System.out.println("\n");
	}
	
	/**
	 * @brief Prints the sum of each column in a 2D array.
	 * @param arr The array.
	 */
	private void sumColumns(int[][] arr)
	{
		int _row = arr[0].length;
		int _col = arr.length;
		
		for (int r = 0; r < _row; r++)
		{
			int sum = 0;
			for (int c = 0; c < _col; c++)
			{
				sum += arr[c][r];
			}
			System.out.println("The sum of column "+(r+1)+" is "+sum+".");
		}
		System.out.println("\n");
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
