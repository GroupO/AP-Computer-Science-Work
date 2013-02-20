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
public class BlackCat extends Cat
{
	String hair;
	/**
	 * @param catName
	 * @param catWeight
	 */
	public BlackCat(String catName, int catWeight, String hairType)
	{
		super(catName, catWeight);
		// TODO Auto-generated constructor stub
		hair = hairType;
	}
	  public String speak() 
	  {
	    return "purr purr!";
	  } 

	  public String move() 
	  {
	    return  "sneak";
	  }
	  
	  public String getHairType()
	  {
		  return hair;
	  }
	  
	  public String toString() 
	  {
		 return (super.toString() + " and is "+hair);
	  }
}
