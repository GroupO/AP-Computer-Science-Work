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
public class MaineCoon extends Cat
{
	String hair;
	/**
	 * @param catName
	 * @param catWeight
	 */
	public MaineCoon(String catName, int catWeight, String hairType)
	{
		super(catName, catWeight);
		hair = hairType;
	}
	  public String speak() 
	  {
	    return "mrow";
	  } 

	  public String move() 
	  {
	    return  "loaf";
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
