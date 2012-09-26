import TurtleGraphics.*;
import javax.swing.*;
import java.awt.*;

public class TestMultiplePads extends JFrame{

   private SketchPad pad1;
   private SketchPad pad2;
   private SketchPad pad3;
   private SketchPad pad4;

   public StandardPen pen1;
   public StandardPen pen2;
   public StandardPen pen3;
   public StandardPen pen4;

   public TestMultiplePads(){
      pad1 = new SketchPad();
      pad2 = new SketchPad();
      pad3 = new SketchPad();
      pad4 = new SketchPad();

      pad1.setBackground(Color.red);
      pad2.setBackground(Color.white);
      pad3.setBackground(Color.green);
      pad4.setBackground(Color.yellow);

      pen1 = new StandardPen(pad1);
      pen2 = new StandardPen(pad2);
      pen3 = new StandardPen(pad3);
      pen4 = new StandardPen(pad4);

      Container container = getContentPane();
      container.setLayout(new GridLayout(2, 2));
      container.add(pad1);
      container.add(pad2);
      container.add(pad3);
      container.add(pad4);
   }

   public static void main (String[] args){
      TestMultiplePads tpo = new TestMultiplePads();
      tpo.setSize(200, 200);
      tpo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      tpo.setVisible(true);
      tpo.pen1.move(50);
      tpo.pen2.move(40);
      tpo.pen3.move(30);
      tpo.pen4.move(20);

  }
}
