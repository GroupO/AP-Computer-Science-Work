// Example 11.7: Data model to maintain the shapes

import java.awt.*;
import java.util.ArrayList;

public class ShapeModel{

   private ArrayList<Shape> shapes;  
	
   public ShapeModel(){
      shapes = new ArrayList<Shape>();
   }

   public void draw(Graphics g){
      for (Shape s : shapes)
         s.draw(g);
   }

   public String add(Shape s){
      shapes.add(s);
      return null;
   }

   public Shape containsPoint(int x, int y){
      for (int i = shapes.size() - 1; i >= 0; i--)
         if (shapes.get(i).containsPoint(x, y))
            return shapes.get(i);
      return null;
   }

   public void delete(Shape s){
      shapes.remove(s);
   }
}
