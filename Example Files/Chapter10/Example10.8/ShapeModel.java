// Example 10.7: Data model to maintain the shapes

import java.awt.*;

public class ShapeModel{

   private Shape[] shapes;
   private int shapeCount;  
	
   public ShapeModel(int size){
      shapes = new Shape[size];
      shapeCount = 0;
   }

   public void draw(Graphics g){
      for (int i = 0; i < shapeCount; i++)
         shapes[i].draw(g);
   }

   public String add(Shape s){
      if (shapeCount == shapes.length)
         return "Sorry: No room in database";
      else{
         shapes[shapeCount] = s;
         shapeCount++;
         return null;
      }
   }

   public Shape containsPoint(int x, int y){
      for (int i = shapeCount - 1; i >= 0; i--)
         if (shapes[i].containsPoint(x, y))
            return shapes[i];
      return null;
   }
}
