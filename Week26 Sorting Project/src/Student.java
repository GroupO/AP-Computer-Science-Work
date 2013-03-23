// Case Study 9.1: Student class

public class Student
{

	private String firstName;
	private String lastName;
	private int[] tests;

	// Default: Name is "" and 3 scores are 0
	public Student()
	{
		this("","");
	}

	// Name is nm and 3 scores are 0
	public Student(String first, String last)
	{
		this(first, last, 3);
	}

	// Name is nm and n scores are 0
	public Student(String first, String last, int n)
	{
		firstName = first;
		lastName = last;
		tests = new int[n];
		for (int i = 0; i < tests.length; i++)
			tests[i] = 0;
	}

	// Name is nm and scores are in t
	public Student(String first, String last, int[] t)
	{
		firstName = first;
		lastName = last;
		tests = new int[t.length];
		for (int i = 0; i < tests.length; i++)
			tests[i] = t[i];
	}

	// Builds a copy of s
	public Student(Student s)
	{
		this(s.firstName, s.lastName, s.tests);
	}

	public int getNumberOfTests()
	{
		return tests.length;
	}

	public void setName(String first, String last)
	{
		firstName = first;
		lastName = last;
	}

	public String getName()
	{
		return firstName + " " + lastName;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}

	public void setScore(int i, int score)
	{
		tests[i - 1] = score;
	}

	public int getScore(int i)
	{
		return tests[i - 1];
	}

	public int getAverage()
	{
		int sum = 0;
		for (int score : tests)
			sum += score;
		return sum / tests.length;
	}

	public int getHighScore()
	{
		int highScore = 0;
		for (int score : tests)
			highScore = Math.max(highScore, score);
		return highScore;
	}

	public String toString()
	{
		String str = "Name:    " + this.getName() + "\n";
		for (int i = 0; i < tests.length; i++)
			str += "test " + (i + 1) + ":  " + tests[i] + "\n";
		str += "Average: " + getAverage();
		return str;
	}

	// Returns null if there are no errors else returns
	// an appropriate error message.
	public String validateData()
	{
		if (firstName.equals("") && lastName.equals("")) return "SORRY: name required";
		for (int score : tests)
		{
			if (score < 0 || score > 100)
			{
				String str = "SORRY: must have " + 0 + " <= test score <= "
						+ 100;
				return str;
			}
		}
		return null;
	}
	
	//Returns true if 's' has a greater ID number than self.
	public boolean compareLastName(Student s)
	{
		char n1[] = this.getLastName().toCharArray();
		char n2[] = s.getLastName().toCharArray();
		int l;
		if (n1.length < n2.length) { l = n1.length; } else { l = n2.length; }
		
		for (int i = 0; i < l; i++)
		{
			if (n1[i] > n2[i]) return true;
			else if (n1[i] < n2[i]) return false;
		}
		
		return false;
	}
	
	//Returns ture if 's' is higher scoring than self.
	public boolean compareAverage(Student s)
	{
		if (s.getAverage() > this.getAverage()) { return true; }
		else { return false; }
	}
}
