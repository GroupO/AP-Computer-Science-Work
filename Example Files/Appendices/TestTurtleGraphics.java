import TurtleGraphics.*;
import javax.swing.*;
import java.awt.*;

public class TestTurtleGraphics extends JFrame{

   private SketchPad leftPad, rightPad;
   private Pen leftPen, rightPen;

   public TestTurtleGraphics(){
      leftPad = new SketchPad();
      rightPad = new SketchPad();
      leftPad.setBackground(Color.pink);
      rightPad.setBackground(Color.yellow);
      leftPen = new StandardPen(leftPad);
      rightPen = new WigglePen(rightPad, 10, 45);
      Container container = getContentPane();
      container.setLayout(new GridLayout(1,2));
      container.add(leftPad);
      container.add(rightPad);
   }

   public static void main(String [] args) {
      TestTurtleGraphics theGUI = new TestTurtleGraphics();
      theGUI.setSize(200, 200);
      theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      theGUI.setVisible(true);
      theGUI.leftPen.move(100, 100);
      theGUI.rightPen.move(100, 100);
   }
}
