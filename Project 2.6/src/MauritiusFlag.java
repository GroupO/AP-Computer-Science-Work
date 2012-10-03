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
 * A class that displays the national flag of Mauritius.
 * @author arthurlockman
 */
public class MauritiusFlag
{

	/**
	 * Displays the flag of Mauritius.
	 * @param args Program arguments.
	 */
	public static void main(String[] args)
	{
		//Initialize JFrame.
		JFrame flagDisplayFrame = new JFrame();
		flagDisplayFrame.setSize(300, 200);
		flagDisplayFrame.setTitle("Stella Clavisque Maris Indici");
		flagDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create JPanel's to handle different color bars in flag.
		JPanel redBar = new JPanel();
		JPanel blueBar = new JPanel();
		JPanel yellowBar = new JPanel();
		JPanel greenBar = new JPanel();
		
		//Initialize bars with correct colors.
		redBar.setBackground(Color.red);
		blueBar.setBackground(Color.blue);
		yellowBar.setBackground(Color.yellow);
		greenBar.setBackground(Color.green);
		
		//Create layout container to display bars in a grid.
		Container _layout = flagDisplayFrame.getContentPane();
		_layout.setLayout(new GridLayout(4,1));
		
		//Add bars to layout container.
		_layout.add(redBar);
		_layout.add(blueBar);
		_layout.add(yellowBar);
		_layout.add(greenBar);
		
		//Make composed frame visible.
		flagDisplayFrame.setVisible(true);
	}

}
