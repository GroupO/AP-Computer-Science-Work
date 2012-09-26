// Example 11.7: displays shapes
// Allows the user to draw shape with a size and position
// Allows the user to drag a shape to another position
// Allows the user to delete a shape
// Uses a distinct data model to maintain the shapes

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;            //For the mouse events
import java.util.Random;

public class ColorPanel extends JPanel{

   private ShapeModel database;   // Now just a model
   private Shape selectedShape;   // Used to track selected shape
   private int x, y;              // Used to track mouse coordinates 
   private String manipType;      // Type of user manipluation
   private String shapeType;      // Type of shape to create
   private Color color;           // Color for new shapes 
	
   public ColorPanel(Color backColor){
      setBackground(backColor);
      database = new ShapeModel();  // Now can have any number of shapes
      selectedShape = null;
      manipType = "Create";
      shapeType = "Circle";
      color = Color.black;   
      addMouseListener(new PanelListener());
      addMouseMotionListener(new PanelMotionListener());
   }

   public void setManipType(String type){
      manipType = type;
   }

   public void setShapeType(String type){
      shapeType = type;
   }

   public void setColor(Color c){
      color = c;
   }
	
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      // Draw all the shapes
      database.draw(g);              
   }

   private class PanelListener extends MouseAdapter{

      public void mousePressed(MouseEvent e){
         x = e.getX();
         y = e.getY();
         // Do nothing if creating
         if (manipType.equals("Create")) return; 
         //Select a shape if it contains the mouse coordinates
         selectedShape = database.containsPoint(x, y);
         if (manipType.equals("Delete") && selectedShape != null){
            // Delete, deselect, and refresh
            database.delete(selectedShape);
            selectedShape = null;
            repaint();
         }
      }

      public void mouseReleased(MouseEvent e){
         int newX = e.getX();
         int newY = e.getY();
         if (manipType.equals("Create")){
            // Get the info and create a shape
            int dx = newX - x; 
            int dy = newY - y;
            Shape s;
            if (shapeType.equals("Circle"))
               s = new Circle(x, y, dx, color);
            else
               s = new Rect(x, y, dx, dy, color);
            s.setFilled(true);
            database.add(s);
            repaint();
         } 
         x = newX;
         y = newY;
         //Deselect the selected shape
         selectedShape = null;
      }        
   }

   private class PanelMotionListener extends MouseMotionAdapter{

      public void mouseDragged(MouseEvent e){
         // Do nothing if creating or deleting
         if (manipType.equals("Create") || manipType.equals("Delete"))
            return;
         //Compute the distance and move the selected shape
         int newX = e.getX();
         int newY = e.getY();
         int dx = newX - x;
         int dy = newY - y;
         if (selectedShape != null)
            selectedShape.move(dx, dy);
         x = newX;
         y = newY; 
         repaint();
      }
   } 
}
