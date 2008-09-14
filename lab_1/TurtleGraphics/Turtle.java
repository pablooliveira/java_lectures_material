package TurtleGraphics;

import java.awt.*;   
import java.awt.image.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Turtle {
  /* shape and color of this turtle */
  private Polygon turtleShape;
  private Color turtleColor = Color.BLUE;
  private Color penColor = Color.WHITE;

  /* position and orientation of this turtle */
  private double x = 0;
  private double y = 0;
  private double theta = 0;
  private boolean pen_down = false;
  
  /* the sheet in which this turtle draws */
  private Sheet sheet = null;
  
  public Turtle(Sheet sheet) {
    this.sheet = sheet;
    sheet.addTurtle(this);
    turtleShape = new Polygon(new int[] {0,0,10}, new int[] {3,-3,0}, 3);
  }
  public void turn(double degrees) {
    double radians = degrees / 180 * Math.PI;
    theta += radians; 
    sheet.repaint();
  }
  
  public void advance(double steps) {
    double newx = x + steps*Math.cos(theta);
    double newy = y + steps*Math.sin(theta);
    if (pen_down && sheet != null) {
      sheet.drawLine(x,y,newx,newy, penColor);
    }
    x = newx;
    y = newy;
    sheet.repaint();
  }

  public void penDown() { pen_down = true; }
  public void penUp() { pen_down = false; }
  public void setPenColor(Color color) { penColor = color; }

  protected void drawTurtle(Graphics2D graphics) {
    graphics.setColor(turtleColor);
    graphics.translate(x,y);     
    graphics.rotate(theta);
    graphics.fill(turtleShape);
  }
}
