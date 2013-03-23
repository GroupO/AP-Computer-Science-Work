import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Author:  Arthur Lockman
 * Date:    Mar 23, 2013
 * School:  Gorham High School
 * 
 * Project: Week26 Sorting Project
 * Package: 
 */

/**
 * @author arthurlockman
 *
 */
public class StudentSorter
{
	private ArrayList<Student> students;
	
	public StudentSorter()
	{
		students = new ArrayList<Student>();
	}

	/**
	 * @brief The main loop.
	 */
	public static void main(String[] args)
	{
		StudentSorter sorter = new StudentSorter();
		sorter.convertToStudents(sorter.getScores("students.txt"));
		while (true)
		{
			sorter.showMenu();
			switch (sorter.getCommand("Select a menu item.\n", 1, 4))
			{
			case 1:
				sorter.printList(sorter.selectionSort(sorter.students));
				break;
			case 2:
				sorter.printList(sorter.bubbleSort(sorter.students));
				break;
			case 3:
				sorter.search(sorter.getStrInput("Enter the name of the student to search for.\n"));
				break;
			case 4:
				System.exit(0);
				break;
			}
		}
	}

	/**
	 * @brief Display the main menu.
	 */
	public void showMenu()
	{
		System.out.println("Menu:\n1: Sort by Last Name\n2: Sort by Average\n3: Search\n4: Quit.\n");
	}
	
	/**
	 * @brief Reads in the project data file from a path relative
	 * to the class itself.
	 * @param dataFileName The name of the data file.
	 * @return The parsed data.
	 */
	public ArrayList<String> getScores(String dataFileName)
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
		
		return scores;
	}
	
	/**
	 * @brief Converts the list of scores to student objects.
	 * @param s The list of raw scores from the data file.
	 */
	public void convertToStudents(ArrayList<String> s)
	{
		for (int i = 0; i < s.size(); i++)
		{
			String[] str = s.get(i).split(" ");
			Student _st = new Student(str[0], str[1], 3);
			_st.setScore(1, Integer.parseInt(str[2]));
			_st.setScore(2, Integer.parseInt(str[3]));
			_st.setScore(3, Integer.parseInt(str[4]));
			students.add(_st);
		}
	}
	
	/**
	 * @brief Get a command input from the user.
	 * @param prompt What to prompt the user with.
	 * @param low the lowest command number acceptable.
	 * @param high the highest command number acceptable.
	 * @return The command received.
	 */
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
	
	/**
	 * @brief Sorts the student list based on name.
	 * @param list the list of students.
	 * @return The sorted list.
	 */
	private ArrayList<Student> selectionSort(ArrayList<Student> list)
	{
		for (int i = 0; i < list.size() - 1; i++)
		{
			int minIndex = findMin(list, i);
			if (minIndex != i)
				swap(list, i, minIndex);
		}
		return list;
	}
	
	/**
	 * @brief Finds the minimum of a list.
	 * @param list the list.
	 * @param first Where to search in the list.
	 * @return The index of the minimum element.
	 */
	private int findMin(ArrayList<Student> list, int first)
	{
		int minIndex = first;
		for (int i = first + 1; i < list.size(); i++)
		{
			if (!list.get(i).compareLastName(list.get(minIndex)))
				minIndex = i;
		}
		return minIndex;
	}
	
	/**
	 * @brief Swap items in an array list.
	 * @param a The list.
	 * @param x Index of item one.
	 * @param y Index of item two.
	 */
	void swap (ArrayList<Student> a, int x, int y)
	{
		Student temp = a.get(x);
		a.set(x, a.get(y));
		a.set(y, temp);
	}
	
	/**
	 * @brief Sort the students by average using bubble sort.
	 * @param a the list to sort.
	 * @return The sorted list.
	 */
	private ArrayList<Student> bubbleSort(ArrayList<Student> a)
	{
		int k = 0;
		boolean exchangeMade = true;
		
		while ((k < a.size() - 1) && exchangeMade)
		{
			exchangeMade = false;
			k++;
			for (int j = 0; j < a.size() - k; j++)
			{
				if (a.get(j).compareAverage(a.get(j+1)))
				{
					swap (a, j, j+1);
					exchangeMade = true;
				}
			}
		}
		return a;
	}
	
	/**
	 * @brief Prints the list of students.
	 * @param list The list to print.
	 */
	private void printList(ArrayList<Student> list)
	{
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i).toString()+"\n");
	}
	
	/**
	 * @brief Search for a student in the student list.
	 * @param name The name or partial name to search for.
	 */
	private void search(String name)
	{
		this.selectionSort(students);
	    
		for (int i = 0; i < students.size(); i++)
		{
			if (students.get(i).getName().contains(name))
			{
				System.out.println("Student found.\n"+students.get(i).toString()+"\n");
				return;
			}
		}
		System.out.println("Student not found.\n");
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
}
