import javax.swing.*;
import java.awt.*;

public class ColorPanel extends JPanel{

   public ColorPanel(Color color){
      setBackground(color);
   }

   public void paintComponent (Graphics g){
      super.paintComponent(g);
       //g.drawArc(10, 25, 50, 50, 0, 90);
       g.drawLine(10, 25, 40, 55);
       //g.drawOval(10, 25, 50, 25);
       //g.drawRoundRect(10, 25, 40, 30, 20, 20);
       //g.drawRect(10, 25, 40, 30);
       //g.drawString("Java is way cool!", 50, 50);
       //g.drawString("Java rules!",  10, 50);
       //g.drawString("(" + getWidth() + "," + getHeight() + ")",
       //             getWidth() / 2, getHeight() / 2);

   }
}
