import java.io.*;
import java.util.*;

class Sort {

  List<String> lines;

  Sort(String fileName) throws IOException {
    lines = new ArrayList<String>();
    BufferedReader in = new BufferedReader(new FileReader(fileName));
    try{
      while(true) {
        String line = in.readLine();
        if (line == null) break;
        lines.add(line);
      }
    } finally {
        in.close();
    }
  }

  void sortLines() {
    Collections.sort(lines);  
  }

  void writeToFile(String fileName) throws IOException {
    Writer out = new BufferedWriter(new FileWriter(fileName));
    try {
      for (String l : lines)
        out.write(l+"\n");
    } finally {
        out.close();
    }
  }

  public static void main(String args[]) throws IOException {
    if (args.length != 1) {
      System.err.println("usage: Sort <file_name>");
      return;
    }
    String fileName = args[0];
    Sort s = new Sort(fileName);
    s.sortLines();
    s.writeToFile("sorted");
  }

}
