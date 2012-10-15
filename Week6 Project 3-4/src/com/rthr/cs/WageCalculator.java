/**
 * Author:  Arthur Lockman
 * Date:    Oct 11, 2012
 * School:  Gorham High School
 * 
 * Project: Week6 Project 3-4
 * Package: com.rthr.cs
 */
package com.rthr.cs;

import java.util.Scanner;

/**
 * Calculates the pay of an employee.
 * 
 * @author arthurlockman
 */
public class WageCalculator
{

	/**
	 * Calculates the pay of an employee. Prompts the user
	 * for all needed data to do the calculations.
	 * @param args Program arguments (none).
	 */
	public static void main(String[] args)
	{
		WageCalculator wCalc = new WageCalculator();
		wCalc.run();
	}
	
	/**
	 * Runs the calculations.
	 */
	public void run()
	{
		//Collect data.
		int employeeID = (int)this.promptForInput("What is the employee ID?");
		double hourlyWage = this.promptForInput("What is the hourly wage of employee "+employeeID+"?");
		double regularHours = this.promptForInput("How many regular hours has employee "+employeeID+" worked?");
		double overtimeHours = this.promptForInput("How many overtime hours has employee "+employeeID+" worked?");
		
		//Process Data
		double totalPay = hourlyWage * regularHours + hourlyWage * 1.5 * overtimeHours;
		
		//Return data.
		System.out.println("Employee "+employeeID+" earned $"+this.round2(totalPay)+" this pay period.");
		
		System.exit(0);
	}
	
	/**
	 * Asks the user for input, and returns the input provided.
	 * @param prompt The prompt to ask for input.
	 * @return A double, what the user typed in in response to the prompt.
	 */
	private double promptForInput(String prompt)
	{
		System.out.println(prompt);
		
		Scanner reader = new Scanner(System.in);
		double input = reader.nextDouble();
		return input;
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
