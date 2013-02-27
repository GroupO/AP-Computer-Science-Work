/**
 * Author:  Arthur Lockman
 * Date:    Feb 25, 2013
 * School:  Gorham High School
 * 
 * Project: Week22 Test Scores
 * Package: 
 */

import java.util.Scanner;

public class TestScoresView
{

	private TestScoresModel model;

	public TestScoresView(TestScoresModel m)
	{
		model = m;
		run();
	}

	// Menu-driven command loop
	private void run()
	{
		while (true)
		{
			//System.out.println("start of run method");
			//System.out.println("Number of students: " + model.size());
			//System.out.println("Index of current student: "
			//		+ model.currentPosition());
			displayMenu();
			int command = getCommand("Enter a number [1-11]: ", 1, 11);
			if (command == 11) break;
			runCommand(command);
		}
	}

	private void displayMenu()
	{
		System.out.println("MAIN MENU");
		System.out.println(" 1. Display the current student.");
		System.out.println(" 2. Display the class average.");
		System.out.println(" 3. Display the student with the highest grade.");
		System.out.println(" 4. Display all students.");
		System.out.println(" 5. Edit the current student.");
		System.out.println(" 6. Add a new student.");
		System.out.println(" 7. Move to the first student.");
		System.out.println(" 8. Move to the last student.");
		System.out.println(" 9. Move to the next student.");
		System.out.println("10. Move to the previous student.");
		System.out.println("11. Quit the program");
	}

	// Prompts the user for a command number and runs until
	// the user enters a valid command number
	// Parameters: prompt is the string to display
	// low is the smallest command number
	// high is the largest command number
	// Returns: a valid command number
	private int getCommand(String prompt, int low, int high)
	{
		// errors checking
		Scanner reader = new Scanner(System.in);
		int command = low - 1;
		while (command < low || command > high)
		{
			System.out.print(prompt);
			command = reader.nextInt();
			if (command < low || command > high)
				System.out.println("Error: command must be between " + low
						+ " and " + high);
		}
		return command;
	}

	// Selects a command to run based on a command number,
	// runs the command, and asks the user to continue by
	// pressing the Enter key
	private void runCommand(int command)
	{
		switch (command)
		{
		case 1: //Display the current student.
			displayStudent();
			break;
		case 2: //Display the class average.
			System.out.println("Average score = " + model.getClassAverage());
			break;
		case 3: //Display the student with the highest grade.
			displayHighScore();
			break;
		case 4: //Display all students.
			displayAllStudents();
			break;
		case 5: //Edit the current student.
			editStudent();
			break;
		case 6: //Add a new student.
			addStudent();
			break;
		case 7: //Move to the first student.
			model.first();
			break;
		case 8: //Move to the last student.
			model.last();
			break;
		case 9: //Move to the next student.
			model.next();
			break;
		case 10: //Move to the previous student.
			model.previous();
			break;
		case 11: //Quit the program
			System.exit(0);
			break;
		}
	}

	/**
	 * @brief Displays all students currently in the TestScoresModel.
	 * Returns the model position to where it was when the 
	 * method was run.
	 */
	private void displayAllStudents()
	{
		int selected = model.currentPosition();
		System.out.println(model.first());
		System.out.println();
		
		for (int i = 1; i < model.size(); i++)
		{
			System.out.println(model.next());
			System.out.println();
		}
		
		model.first();
		while (model.currentPosition() != selected)
		{
			model.next();
		}
		
	}
	
	/**
	 * @brief Displays the current student.
	 */
	private void displayStudent()
	{
		Student s = model.currentStudent();
		if (s == null) System.out.println("No student is currently available.\n");
		else System.out.println(s);
		System.out.println();
	}

	/**
	 * @brief Displays the student with the highest score.
	 */
	private void displayHighScore()
	{
		Student s = model.getHighScore();
		if (s == null)
		{
			System.out.println("No student is currently available.\n");
			return;
		} 
		else
		{
			System.out.println(s.toString());
			System.out.println();
		}
	}

	/**
	 * @brief Adds a student to the TestScoresModel.
	 */
	private void addStudent()
	{
		Student s = new Student(getStrInput("Enter the name: "), 
				getIntInput("How many tests does this student have?"));
		for (int i = 1; i <= s.getNumberOfTests(); i++)
		{
			s.setScore(i, getIntInput("Enter score "+i+"."));
		}
		String message = s.validateData();
		if (message != null) System.out.println(message);
		else
		{
			message = model.add(s);
			if (message != null) System.out.println(message);
			else System.out.println("Student added.\n");
		}
	}

	/**
	 * @brief Edits the currently selected student in the TestScoresModel.
	 */
	private void editStudent()
	{
		Student s = model.currentStudent();
		if (s == null) System.out.println("No student is currently available.\n");
		else
		{
			// Work on a temporary copy
			Student temp = new Student(s);
			String menu = "EDIT MENU\n" 
					+ "1. Change the name\n"
					+ "2. Change a score\n" 
					+ "3. View the student\n"
					+ "4. Quit this menu\n";
			int command = 1;
			while (command != 4)
			{
				System.out.print(menu);
				command = getCommand("Enter a number [1-4]: ", 1, 4);
				switch (command)
				{
				case 1:
					temp.setName(getStrInput("Please enter a new name for the student."));
					break;
				case 2:
					temp.setScore(getIntInput("Which test number?"), 
							getIntInput("What score did this test earn?"));
					break;
				case 3:
					System.out.println(temp);
					break;
				} 
			}
			
			String message = temp.validateData();
			if (message != null) System.out.println(message);
			else model.replace(temp);
			return;
		}
	}
	
	/**
	 * @brief Get string input from the command line.
	 * @param prompt The prompt to prompt for input.
	 */
	private String getStrInput(String prompt)
	{
		System.out.println(prompt); 
		Scanner reader = new Scanner(System.in);
		return reader.nextLine();
	}
	
	/**
	 * @brief Get int input from the command line.
	 * @param prompt The prompt to prompt for input.
	 */
	private int getIntInput(String prompt)
	{
		System.out.println(prompt); 
		Scanner reader = new Scanner(System.in);
		return reader.nextInt();
	}
}
