// Cat is A pet
// Cat extends AbstrPets by defining the abstract methods as concrete

public class Cat  extends  AbstrPets
{
  private int weight;

  public Cat (String catName, int catWeight)
  {
    super (catName); 
    weight = catWeight;
  }

  public int getWeight()
  {
    return weight;
  }

  public String toString() 
  {
    return (super.toString() + " is a cat, weighing " + weight + " pounds");
  }

  public String speak()  // defines abstract method speak for Cat
  {
    return "Meow!!!";
  } 

  public String move()  // defines abstract method  move  for Cat
  {
    return  "shoom";
  }

  
}