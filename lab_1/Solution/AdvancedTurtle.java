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

  static public void main(String args[]) {
    Sheet sheet = new Sheet(300,300);
    AdvancedTurtle t = new AdvancedTurtle(sheet); 
    t.penDown();
    t.triangle(50);
  }
}
