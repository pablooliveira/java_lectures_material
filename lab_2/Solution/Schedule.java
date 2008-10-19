import java.util.*;
public class Schedule extends ArrayList<Course>{
static int days = 2;



public void checkSchedule(Course course) throws IncompatibleSchedule{
  // Check that course is compatible with all the other courses that happens this same day
  for (Course c: this)
    if (c != course)
      if (c.getDay() == course.getDay() && !c.compatible(course)) throw new IncompatibleSchedule(); 
}

public void updateSchedule() throws IncompatibleSchedule, ScheduleFound {
  // Find the first unscheduled course
  Course unscheduled = null;
  for (Course c: this)
    if (!c.scheduled()) {
      unscheduled = c;
      break;
    }
  if (unscheduled == null) throw new ScheduleFound(); // all the courses have been scheduled

  // Try to schedule the unscheduled course

  for (int d=0; d<days; d++) {
    unscheduled.setDay(d);
    try {
      checkSchedule(unscheduled);
      updateSchedule();
    } catch (IncompatibleSchedule e) {
      unscheduled.unschedule();
    }
  }
  throw new IncompatibleSchedule();
}

void print() {
  for (Course c: this) {
    System.out.println(c.getName() + " on day " + c.getDay());
  }
}

public static void main(String args[]) {
    People people = new People();
    Teacher edna = new Teacher("Edna","Krabappel");
    Teacher marc = new Teacher("Marc","Kluf");
    Student bart = new Student("Bart", "Simpson", 5);
    Student zoe = new Student("Zoe", "Appelzaft", 3);
    Student fred = new Student("Fred", "Cantanat",7);

    people.add(edna);
    people.add(marc);
    people.add(bart);
    people.add(zoe);
    people.add(fred);

    people.sort();
    people.printList();

    Schedule schedule = new Schedule();

    Course math = new Course("math", edna);
    Course java = new Course("java", marc);
    math.add(bart);
    math.add(zoe);
    java.add(fred);
    java.add(zoe);
    schedule.add(math);
    schedule.add(java);
    try {
      schedule.updateSchedule();
    } catch(IncompatibleSchedule e) {
      System.out.println("no schedule found");
    } catch(ScheduleFound s) {
      System.out.println("schedule found");
      schedule.print();
    }
}
}
