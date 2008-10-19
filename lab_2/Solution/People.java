import java.util.*;

public class People extends ArrayList<Person>{
  public void sort() {
    Collections.sort(this);
  }

  public void printList() {
    for (Person p : this) {
      p.print();
    }
  }
}
