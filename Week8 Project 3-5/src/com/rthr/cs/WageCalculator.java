/**
 * Author:  Arthur Lockman
 * Date:    Oct 24, 2012
 * School:  Gorham High School
 * 
 * Project: Week8 Project 3-5
 * Package: com.rthr.cs
 */
package com.rthr.cs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Calculates the pay of an employee.
 * 
 * @author arthurlockman
 */
public class WageCalculator
{
	private static FileInputStream inFile;
	private static InputStreamReader inReader;
	private static BufferedReader reader;
	
	private static String employeeName;
	private static double hourlyWage = 0;
	private static double regularHours = 0;
	private static double overtimeHours = 0;
	
	/**
	 * Calculates the pay of an employee. Prompts the user
	 * for all needed data to do the calculations.
	 * @param args Program arguments (none).
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException
	{
		WageCalculator wCalc = new WageCalculator();
		wCalc.run();
	}
	
	/**
	 * Runs the wage calculations.
	 * @throws IOException 
	 */
	public void run() throws IOException
	{
		
		//Collect data.
		this.initFile("/Users/arthurlockman/Dropbox/School/AP CS/Work/Data Files/VHSP35data1_1.txt/");
		this.parseData();
		
		//Return data.
		double totalPay = this.findTotalPay(hourlyWage, regularHours, overtimeHours);
		System.out.println("Employee "+employeeName+" earned $"+totalPay+" this week.");
		
		System.exit(0);
	}
	
	/**
	 * Prepares the file for input.
	 * @param filePath the path to the file.
	 */
	private void initFile(String filePath)
	{
		try
		{
			inFile = new FileInputStream(filePath);
			inReader = new InputStreamReader(inFile);
			reader = new BufferedReader(inReader);
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	/**
	 * Parses the data in the data file.
	 * @throws IOException 
	 */
	private void parseData() throws IOException
	{
		String data = reader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(data);
		
		employeeName = tokenizer.nextToken()+" "+tokenizer.nextToken();
		hourlyWage = Double.parseDouble(tokenizer.nextToken());
		
		for (int i=0; i<tokenizer.countTokens(); i++)
		{
			regularHours = regularHours + Double.parseDouble(tokenizer.nextToken());
			overtimeHours = overtimeHours + Double.parseDouble(tokenizer.nextToken());
		}
	}
	
	/**
	 * Calculates the total pay of the employee.
	 * 
	 * @param hourlyWage The employee's hourly wage.
	 * @param regularHours The total number of regular hours worked by the employee.
	 * @param overtimeHours The total number of overtime hours worked by the employee.
	 * @return A double, the total pay of the employee.
	 */
	private double findTotalPay(double hourlyWage, double regularHours, double overtimeHours)
	{
		return this.round2(hourlyWage * regularHours + hourlyWage * 1.5 * overtimeHours);
	}

	/**
	 * Rounds a double to two decimal places.
	 * @param num The number to round.
	 * @return A double, rounded to two decimal places.
	 */
	private double round2(double num)
	{
		double num1 = num*100;
		num1 = num1+.5;
		int num2 = (int)num1;
		num1 = (double)num2;
		num1 = num1/100;
		return num1;
	}
}
