import java.util.*;
public class Course extends ArrayList<Student>{
  static int notScheduled = -1;
  private String name;
  private Teacher teacher;
  private int dayOfWeek;

  Course(String name, Teacher teacher) {
    this.name = name;
    this.teacher = teacher;
    this.dayOfWeek = notScheduled;
  }

  public int getDay() {
    return dayOfWeek;
  }

  public String getName() {
    return name;
  }

  public void setDay(int dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public void unschedule() {
    this.dayOfWeek = notScheduled;
  }

  public boolean scheduled() {
    return dayOfWeek != notScheduled;
  }

  public Teacher getTeacher() {
    return teacher;
  }

  public boolean compatible(Course other) {
    /* Check that teachers are not the same */
    if (this.getTeacher().equals(other.getTeacher()))
      return false;
    /* Check that the union of the two courses' students is empty */
    for (Student s : this)
        if (other.contains(s)) return false;
    
    return true;
  }
}
