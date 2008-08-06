import java.util.*;
import javax.swing.*; 
import java.awt.*;   
import java.awt.image.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Sheet extends JPanel {
  /* The image and associated graphic in which the turtles draw */ 
  private Image offscreen;  
  private Graphics2D gra;

  /* The collection of turtles drawing in this sheet */
  public Collection<Turtle> turtles;

  /* The width and height of the sheet */
  private int width;
  private int height;

  public Sheet(int width, int height) {
    this.width = width;
    this.height = height;

    /* Create an image for the turtles to draw in */
    offscreen = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    gra = (Graphics2D) offscreen.getGraphics();
    gra.translate(width/2,height/2); 
    gra.scale(1,-1);

    /* Create a list to keep the turtles */
    turtles = new LinkedList<Turtle>();

    /* Create a frame to show the sheet */
    JFrame f = new JFrame("Turtle");
    f.setSize(width, height);
    f.getContentPane().add(this);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
  }

  /* draw a line in the sheet image */
  public void drawLine(double ax, double ay, double bx, double by) {
    gra.draw(new Line2D.Double(ax,ay,bx,by));
  }
    
  /* draw the sheet: the sheet image and all the turtles */
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    
    /* draw the sheet image */ 
    g2.drawImage(offscreen,0,0,this);     

    /* set turtle coordinate system */
    g2.translate(width/2,height/2); 
    g2.scale(1,-1);

    /* draw each turtle */
    Iterator<Turtle> it = turtles.iterator();
    while(it.hasNext()) {
      Turtle t = it.next();
      t.drawTurtle(g2);
    }
  }

  public void addTurtle(Turtle t) {
    turtles.add(t);
    t.setSheet(this);
  }
}
