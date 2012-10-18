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
	 * Runs the wage calculations.
	 */
	public void run()
	{
		//Collect data.
		int employeeID = (int)this.promptForDoubleInput("What is the employee ID?");
		String employeeName = this.promptForStringInput("What is the employee's full name?");
		
		double hourlyWage = this.promptForDoubleInput(
				"What is "+employeeName+"'s hourly wage?");
		
		double regularHours = this.promptForDoubleInput(
				"How many regular hours did "+employeeName+" work on Monday?");
		double overtimeHours = this.promptForDoubleInput(
				"How many overtime hours did "+employeeName+" work on Monday?");
		regularHours = regularHours + this.promptForDoubleInput(
				"How many regular hours did "+employeeName+" work on Tuesday?");
		overtimeHours = overtimeHours + this.promptForDoubleInput(
				"How many overtime hours did "+employeeName+" work on Tuesday?");
		regularHours = regularHours + this.promptForDoubleInput(
				"How many regular hours did "+employeeName+" work on Wednesday?");
		overtimeHours = overtimeHours + this.promptForDoubleInput(
				"How many overtime hours did "+employeeName+" work on Wednesday?");
		regularHours = regularHours + this.promptForDoubleInput(
				"How many regular hours did "+employeeName+" work on Thursday?");
		overtimeHours = overtimeHours + this.promptForDoubleInput(
				"How many overtime hours did "+employeeName+" work on Thursday?");
		regularHours = regularHours + this.promptForDoubleInput(
				"How many regular hours did "+employeeName+" work on Friday?");
		overtimeHours = overtimeHours + this.promptForDoubleInput(
				"How many overtime hours did "+employeeName+" work on Friday?");
		
		//Process Data
		double totalPay = findTotalPay(hourlyWage, regularHours, overtimeHours);
		
		//Return data.
		System.out.println("Employee "+employeeName+" ("+employeeID+")"+" earned $"+this.round2(totalPay)+" this week.");
		
		System.exit(0);
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
		return hourlyWage * regularHours + hourlyWage * 1.5 * overtimeHours;
	}
	
	/**
	 * Asks the user for input, and returns the input provided.
	 * @param prompt The prompt to ask for input.
	 * @return A double, what the user typed in in response to the prompt.
	 */
	private double promptForDoubleInput(String prompt)
	{
		//Prompt the user
		System.out.println(prompt);
		
		//Read in the double.
		Scanner reader = new Scanner(System.in);
		double input = reader.nextDouble();
		return input;
	}
	
	/**
	 * Asks the user for input, and returns the input provided.
	 * @param prompt The prompt to ask for input.
	 * @return A string, what the user typed in in response to the prompt.
	 */
	private String promptForStringInput(String prompt)
	{
		//Prompt the user
		System.out.println(prompt);
		
		//Read in the double.
		Scanner reader = new Scanner(System.in);
		String input = reader.nextLine();
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
