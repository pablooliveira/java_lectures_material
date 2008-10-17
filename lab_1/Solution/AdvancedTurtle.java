import java.awt.Color;
import TurtleGraphics.Sheet;
import TurtleGraphics.Turtle;

public class AdvancedTurtle extends Turtle {
  public AdvancedTurtle(Sheet s) {
    super(s);
  }

  public void triangle(double side) {
    advance(side);
    turn(120);
    advance(side);
    turn(120);
    advance(side);
  }

  public void square(double side) {
    advance(side);
    turn(90);
    advance(side);
    turn(90);
    advance(side);
    turn(90);
    advance(side);
  }

  public void circle(double radius) {
    penUp();
    advance(radius);
    turn(90);
    penDown();
    int i;
    for (i=0;i<360;i++) {
      turn(1);
      advance(Math.PI*radius/180);
    }
    penUp();
  }
 
  public void koch(int n, double size) {
    penDown(); 
    if (n > 0) {
      size = size / 3; 
      koch(t, n-1,size);
      turn(60);
      koch(t, n-1,size);
      turn(-120);
      koch(t, n-1,size);
      turn(60);
      koch(t, n-1,size);
    } else 
    {
      advance(size);
    }
    penUp();
  }

  static public void main(String args[]) {
    Sheet sheet = new Sheet(300,300);
    AdvancedTurtle t = new AdvancedTurtle(sheet); 
    t.penDown();
    t.square(50);
  }
}
