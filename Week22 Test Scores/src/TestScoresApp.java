/**
 * Author:  Arthur Lockman
 * Date:    Feb 25, 2013
 * School:  Gorham High School
 * 
 * Project: Week22 Test Scores
 * Package: 
 */

public class TestScoresApp
{

	public static void main(String[] args)
	{
		TestScoresModel model = new TestScoresModel();
		new TestScoresView(model);
	}
}
