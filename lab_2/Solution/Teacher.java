public class Teacher extends Person {
  Teacher(String firstName, String lastName) {
    super(firstName, lastName);
  }

  public void print() {
    System.out.println(getFirstName() + " " + getLastName() + " teacher");
  }
}
