public class Schnauzer extends Dog 
{
  private String whereFrom;
  
  public Schnauzer (String dogName, int weight)
  {
    super (dogName,weight);
  }
  
  public void setPlace(String location)
  {
    whereFrom = location;
  }
  
  public String speak()  // overwrites speak in Dog
  {
    return "Yip yip!";
  } 
  
  public String move()  // overwrites move in Dog
  {
    return  "click clack tappata tappata";
  }
  
  public String cityOfOrigin()
  {
    return whereFrom;
  }  
  
}