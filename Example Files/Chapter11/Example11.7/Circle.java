// Represents a circle

import java.awt.*;

public class Circle implements Shape{

   private int centerX, centerY, radius;
   private Color color;
   private boolean filled;

   public Circle(int x, int y, int r, Color c){
      centerX = x;
      centerY = y;
      radius = r;
      color = c;
      filled = false;
   }

   public void draw(Graphics g){
      Color oldColor = g.getColor();
      g.setColor(color);
      // Translates circle's center to rectangle's origin for drawing.
      if (filled)
         g.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
      else
         g.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
      g.setColor(oldColor);
   }

   public boolean containsPoint(int x, int y){
      int xSquared = (x - centerX) * (x - centerX);
      int ySquared = (y - centerY) * (y - centerY);
      int radiusSquared = radius * radius;
      return xSquared + ySquared - radiusSquared <= 0;
   }

   public void move(int xAmount, int yAmount){
      centerX = centerX + xAmount;
      centerY = centerY + yAmount;
   }

   public void setFilled(boolean b){
      filled = b;
   }
}



