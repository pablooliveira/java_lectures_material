public class Student extends Person {
  private int year;
  
  Student(String firstName, String lastName, int year) {
    super(firstName, lastName);
    this.year = year;
  }

  public void print() {
    System.out.println(getFirstName() + " " + getLastName() + " Student in " + year + " year");
  }
}
