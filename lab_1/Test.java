import java.awt.Color;
import TurtleGraphics.*;

public class Test {

  static public void circle(Turtle t, double radius) {
    t.penUp();
    t.advance(radius);
    t.turn(90);
    t.penDown();
    int i;
    for (i=0;i<360;i++) {
      t.turn(1);
      t.advance(Math.PI*radius/180);
    }
    t.penUp();
  }
 
  static public void koch(Turtle t, int n, double size) {
    t.penDown(); 
    if (n > 0) {
      size = size / 3; 
      koch(t, n-1,size);
      t.turn(60);
      koch(t, n-1,size);
      t.turn(-120);
      koch(t, n-1,size);
      t.turn(60);
      koch(t, n-1,size);
    } else 
    {
      t.advance(size);
    }
    t.penUp();
  }

  static public void main(String[] args) {
    Sheet s = new Sheet(300,300);
    Turtle t = new Turtle(s);
    circle(t,100);
    t.turn(120);
    double side = Math.cos(Math.PI/6)*200;
    koch(t, 4,side); 
    t.turn(-120);
    koch(t, 4,side); 
    t.turn(-120);
    koch(t, 4,side); 
  }
}
