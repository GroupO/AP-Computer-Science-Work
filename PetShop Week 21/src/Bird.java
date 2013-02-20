// Cat is A pet
// Cat extends AbstrPets by defining the abstract methods as concrete

public class Bird extends AbstrPets
{
  private int weight;

  public Bird (String birdName, int birdWeight)
  {
    super (birdName); 
    weight = birdWeight;
  }

  public int getWeight()
  {
    return weight;
  }

  public String toString() 
  {
    return (super.toString() + " is a bird, weighing " + weight + " ounces");
  }

  public String speak()  // defines abstract method speak for Cat
  {
    return "Tweet tweet!!!";
  } 

  public String move()  // defines abstract method  move  for Cat
  {
    return  "fly";
  }

  
}