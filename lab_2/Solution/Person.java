public abstract class Person implements Comparable<Person>{
  private String firstName;
  private String lastName;
  
  String getFirstName() {return firstName;}
  String getLastName() {return lastName;}

  Person (String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  abstract public void print();

  public int compareTo(Person p2) {
    if (this.getLastName().equals(p2.getLastName())) {
      return this.getFirstName().compareTo(p2.getFirstName());
    } else
      return this.getLastName().compareTo(p2.getLastName());
  }
}
