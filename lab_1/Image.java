import java.awt.Color;
import java.io.*;
import TurtleGraphics.*;

public class Image {

  static private InputStream is;

  static public String readWord() throws IOException {
    StringBuilder sb = new StringBuilder();
    while (true) {
      char b = (char) is.read();
      if (b == ' ' || b == '\n') return sb.toString();
      sb.append(b);
    }
  }

  static public void main(String[] args) {
    try {
      is = new FileInputStream(args[0]);

      String comment = readWord(); 
      int width = Integer.parseInt(readWord(),10);
      int height = Integer.parseInt(readWord(),10);
      String colors = readWord();
      System.out.println(width + "x" + height);

      Sheet s = new Sheet(width,height);

      Turtle t = new Turtle(s);
      t.advance(-width/2);
      t.turn(90);
      t.advance(height/2);
      t.turn(-90);
      
      // rows first
      for (int row = 0; row < height; row ++) {
        t.penDown();
        for (int col = 0; col < width; col ++) {
          // draw row
          int r = is.read();
          int g = is.read();
          int b = is.read();
          t.setPenColor(new Color(r,g,b));
          t.advance(1);
        }
        t.penUp();

        // move turtle at next line's start
        t.advance(-width);
        t.turn(-90);
        t.advance(1);
        t.turn(90);
      }

    } catch (Exception e) {
      System.err.println("Problem reading file.");
    }
  }
}
