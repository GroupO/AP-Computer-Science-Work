public class KingCobra extends Snake 
{
  private String color;
  
  public KingCobra (String snakeName, int snakeLength)
  {
    super (snakeName, snakeLength);
  }
  
  public void setColor(String newColor)
  {
    color = newColor;
  }
  
  public String speak()
  {
    return "HISS";
  } 
  
  public String move() 
  {
    return  "slither STRIKE";
  } 
  
  public String getColor()
  {
	  return color;
  }
}