package TurtleGraphics;

import java.awt.*;

/**
<B><I>Copyright 2006</I></B> by Ken Lambert and Martin Osborne.
<BR><BR>
Provides default behavior and state for a pen.  The pen's initial color is blue and its width is 2 pixels.  It is situated at the origin of a sketchpad, facing north (90 degrees).  It is placed down on the sketchpad, ready to draw.
*/

public class StandardPen extends AbstractPen {

   // Constructors ------------------------------
   
   /**   
   Action: Pops up an application window containing a sketchpad 
   and an associated standard pen.
   */   
   public StandardPen(){
      this(new SketchPad());
      new SketchPadWindow(pad);
   }

   /**   
   Action: Associates a standard pen with a client-supplied sketchpad.
   */   
   public StandardPen(SketchPad p){
      super(p);
   }

   /**   
   Action: Pops up the client's application window containing a sketchpad 
   and an associated standard pen.
   */   
   public StandardPen(SketchPadWindow w){
      this(new SketchPad());
      Container c = w.getContentPane();
      c.add(pad);
      w.setVisible(true);
   }


   // Public methods ----------------------------
   
   public void drawString(String text) {
      pad.setColor(color);
      pad.drawString(text, xPos, yPos, color);
   }
   
   // Protected methods -------------------------

   protected void drawLine(double x, double y){
      if (isDown){
         pad.setColor(color);
         pad.setPenWidth(width);
         pad.drawLine(xPos, yPos, x, y, color, width);
      }
      xPos = x;
      yPos = y;
   }   
}
