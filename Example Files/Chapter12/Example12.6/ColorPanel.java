// Example 12.6: Panel to draw c-curves

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorPanel extends JPanel{
	
   private int level;

   public ColorPanel(Color backColor){
      setBackground(backColor);
      setPreferredSize(new Dimension(300, 200));
      level = 0;
   }
	
   public void setLevel(int newLevel){
      level = newLevel;
      repaint();
   }

   public void paintComponent (Graphics g){
      super.paintComponent(g);
      cCurve(g, 150, 50, 150, 150, level);
   }

   private void cCurve (Graphics g, int x1, int y1, int x2, int y2, int level){
      if (level == 0)
         g.drawLine (x1, y1, x2, y2);
      else{
         int xm = (x1 + x2 + y1 - y2) / 2;
         int ym = (x2 + y1 + y2 - x1) / 2;
         cCurve (g, x1, y1, xm, ym, level - 1);
         cCurve (g, xm, ym, x2, y2, level - 1);
      }
   }
}	
