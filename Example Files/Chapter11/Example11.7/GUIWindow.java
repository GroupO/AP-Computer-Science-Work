// Example 11.7: Main view class for shape drawing program
// with menus import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIWindow extends JFrame{

   private JMenuItem createMI = new JMenuItem("Create");
   private JMenuItem moveMI = new JMenuItem("Move");
   private JMenuItem deleteMI = new JMenuItem("Delete");
   private JMenuItem circleMI = new JMenuItem("Circle");
   private JMenuItem rectMI = new JMenuItem("Rectangle");
   private JMenuItem blackMI = new JMenuItem("Black");
   private JMenuItem blueMI = new JMenuItem("Blue");
   private JMenuItem redMI = new JMenuItem("Red");
   private JMenuItem randomMI = new JMenuItem("Random");
   private ColorPanel panel = new ColorPanel(Color.white);

   public GUIWindow(){
      Container pane = getContentPane();
      pane.add(panel);
      JMenu shapeMenu = new JMenu("Shape");
      shapeMenu.add(createMI);
      shapeMenu.add(moveMI);
      shapeMenu.add(deleteMI);
      JMenu typeMenu = new JMenu("Type");
      typeMenu.add(circleMI);
      typeMenu.add(rectMI);
      JMenu colorMenu = new JMenu("Color");
      colorMenu.add(blackMI);
      colorMenu.add(blueMI);
      colorMenu.add(redMI);
      colorMenu.add(randomMI);
      JMenuBar bar = new JMenuBar();
      bar.add(shapeMenu);
      bar.add(typeMenu);
      bar.add(colorMenu);
      setJMenuBar(bar);
      createMI.addActionListener(new CreateListener());
      moveMI.addActionListener(new MoveListener());
      deleteMI.addActionListener(new DeleteListener());
      circleMI.addActionListener(new CircleListener());
      rectMI.addActionListener(new RectListener());
      redMI.addActionListener(new RedListener());
   }

   private class CreateListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         panel.setManipType("Create");
      }
   }

   private class MoveListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         panel.setManipType("Move");
      }
   }

   private class DeleteListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         panel.setManipType("Delete");
      }
   }

   private class CircleListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         panel.setShapeType("Circle");
      }
   }

   private class RectListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         panel.setShapeType("Rect");
      }
   }

   private class RedListener implements ActionListener{
      public void actionPerformed(ActionEvent e){
         panel.setColor(Color.red);
      }
   }
}