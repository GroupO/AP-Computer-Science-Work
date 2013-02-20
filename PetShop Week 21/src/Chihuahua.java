public class Chihuahua extends Dog 
{
  private String whereFrom;
  
  public Chihuahua (String dogName, int weight)
  {
    super (dogName,weight);
  }
  
  public void setPlace(String location)
  {
    whereFrom = location;
  }
  
  public String speak()  // overwrites speak in Dog
  {
    return "chalupa!!";
  } 
  
  public String move()  // overwrites move in Dog
  {
    return  "little tiny steps";
  }
  
  public String cityOfOrigin()
  {
    return whereFrom;
  }  
  
}