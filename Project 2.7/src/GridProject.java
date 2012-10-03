import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * Author:  Arthur Lockman
 * Date:    Oct 2, 2012
 * School:  Gorham High School
 * 
 * Project: Project 2.7
 * Package: 
 */

/**
 * A class that displays a 3 by 3 grid of black and white
 * squares, such that no two squares of the same color
 * are adjacent to each other.
 * 
 * @author arthurlockman
 */
public class GridProject
{

	/**
	 * Displays the grid.
	 * @param args Program arguments.
	 */
	public static void main(String[] args)
	{
		//Initialize JFrame.
		JFrame flagDisplayFrame = new JFrame();
		flagDisplayFrame.setSize(400, 400);
		flagDisplayFrame.setTitle("Checkers, anyone?");
		flagDisplayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create JPanels to handle different color squares on the grid.
		//Surely there has to be an easier way than to make 9 JPanels?
		JPanel blackSquare1 = new JPanel();
		JPanel blackSquare2 = new JPanel();
		JPanel blackSquare3 = new JPanel();
		JPanel blackSquare4 = new JPanel();
		JPanel blackSquare5 = new JPanel();
		JPanel whiteSquare1 = new JPanel();
		JPanel whiteSquare2 = new JPanel();
		JPanel whiteSquare3 = new JPanel();
		JPanel whiteSquare4 = new JPanel();
		
		//Initialize squares with correct colors.
		blackSquare1.setBackground(Color.black);
		blackSquare2.setBackground(Color.black);
		blackSquare3.setBackground(Color.black);
		blackSquare4.setBackground(Color.black);
		blackSquare5.setBackground(Color.black);
		whiteSquare1.setBackground(Color.white);
		whiteSquare2.setBackground(Color.white);
		whiteSquare3.setBackground(Color.white);
		whiteSquare4.setBackground(Color.white);

		
		//Create layout container to display squares in a grid.
		Container _layout = flagDisplayFrame.getContentPane();
		_layout.setLayout(new GridLayout(3,3));
		
		//Add squares to layout container.
		_layout.add(blackSquare1);
		_layout.add(whiteSquare1);
		_layout.add(blackSquare2);
		_layout.add(whiteSquare2);
		_layout.add(blackSquare3);
		_layout.add(whiteSquare3);
		_layout.add(blackSquare4);
		_layout.add(whiteSquare4);
		_layout.add(blackSquare5);
		
		//Make composed frame visible.
		flagDisplayFrame.setVisible(true);
	}

}
