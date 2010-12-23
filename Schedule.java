import java.util.*;

/* 
   Version 12/23
   Needs lots of work, not sure if instance variables are smart. 
*/

public class Schedule implements Comparable<Schedule> {

    // Not sure if this is the best choice of instance variables
    private HashMap<Person, TimeSlot> s;
    private Vector<Person> people;
    private Vector<TimeSlot> times;

    public Schedule(Vector<Person> people, Vector<TimeSlot> times) {
	this.people = people;
	this.times = times;
    }

    public void schedulePerson(Person p, TimeSlot t) {
	s.add(p, t);
    }

    /* Not done. */
    public int compareTo(Schedule other) {
	return 0;
    }

}