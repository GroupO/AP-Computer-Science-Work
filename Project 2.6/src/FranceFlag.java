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
 * A class that displays the national flag of France.
 * @author arthurlockman
 */
public class FranceFlag
{

	/**
	 * Displays the flag of France.
	 * @param args Program arguments.
	 */
	public static void main(String[] args)
	{
		//Initialize JFrame.
		JFrame flagDisplayFrame = new JFrame();
		flagDisplayFrame.setSize(300, 200);
		flagDisplayFrame.setTitle("Liberté, égalité, fraternité");
		flagDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create JPanel's to handle different color bars in flag.
		JPanel blueBar = new JPanel();
		JPanel whiteBar = new JPanel();
		JPanel redBar = new JPanel();
		
		//Initialize bars with correct colors.
		blueBar.setBackground(Color.blue);
		whiteBar.setBackground(Color.white);
		redBar.setBackground(Color.red);
		
		//Create layout container to display bars in a grid.
		Container _layout = flagDisplayFrame.getContentPane();
		_layout.setLayout(new GridLayout(1,3));
		
		//Add bars to layout container.
		_layout.add(blueBar);
		_layout.add(whiteBar);
		_layout.add(redBar);
		
		//Make composed frame visible.
		flagDisplayFrame.setVisible(true);
	}

}
