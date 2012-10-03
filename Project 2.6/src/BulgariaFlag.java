import javax.swing.*; 

import java.awt.*;

/**
 * Author:  Arthur Lockman
 * Date:    Oct 2, 2012
 * School:  Gorham High School
 * 
 * Project: Project 2.6
 * Package: 
 */

/**
 * A class that displays the national flag of Bulgaria.
 * @author arthurlockman
 */
public class BulgariaFlag
{

	/**
	 * Displays the flag of Bulgaria.
	 * @param args Program arguments.
	 */
	public static void main(String[] args)
	{
		//Initialize JFrame.
		JFrame flagDisplayFrame = new JFrame();
		flagDisplayFrame.setSize(300, 200);
		flagDisplayFrame.setTitle("Unity renders power!");
		flagDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create JPanel's to handle different color bars in flag.
		JPanel whiteBar = new JPanel();
		JPanel greenBar = new JPanel();
		JPanel redBar = new JPanel();
		
		//Initialize bars with correct colors.
		whiteBar.setBackground(Color.white);
		greenBar.setBackground(Color.green);
		redBar.setBackground(Color.red);
		
		//Create layout container to display bars in a grid.
		Container _layout = flagDisplayFrame.getContentPane();
		_layout.setLayout(new GridLayout(3,1));
		
		//Add bars to layout container.
		_layout.add(whiteBar);
		_layout.add(greenBar);
		_layout.add(redBar);
		
		//Make composed frame visible.
		flagDisplayFrame.setVisible(true);
	}

}
