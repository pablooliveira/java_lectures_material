import java.awt.Color;

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
  }

  static public void koch(Turtle t, int n,double size) {
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
  }

  static public void main(String[] args) {
    Sheet s = new Sheet(400,400);
    
    Turtle t = new Turtle();
    s.addTurtle(t);
    circle(t,100);
    //t.advance(-200);
    //koch(t, 5,400); 
  }
}
