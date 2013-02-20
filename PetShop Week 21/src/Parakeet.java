/**
 * Author:  Arthur Lockman
 * Date:    Feb 20, 2013
 * School:  Gorham High School
 * 
 * Project: PetShop Week 21
 * Package: 
 */

/**
 * @author arthurlockman
 *
 */
public class Parakeet extends Bird
{
	String color;
	/**
	 * @param birdName
	 * @param birdWeight
	 */
	public Parakeet(String birdName, int birdWeight, String birdColor)
	{
		super(birdName, birdWeight);
		color = birdColor;
	}
		
	  public void setColor(String newColor)
	  {
	    color = newColor;
	  }
	  
	  public String speak()
	  {
	    return "tweet tweet!";
	  } 
	  
	  public String move() 
	  {
	    return  "flutter!";
	  } 
	  
	  public String getColor()
	  {
		  return color;
	  }

}
