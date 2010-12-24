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

    public boolean canSchedule(Person p, TimeSlot t) {
	return t.canAddPerson();
    }

    public void schedule(Person p, TimeSlot t) {
	s.put(p, t);
	p.scheduleTime(t);
	t.addPerson();
    }

    public void remove(Person p) {
	s.get(p).removePerson();
	s.remove(p);
	p.scheduleTime(null);
    }

    /* Not done. */
    public int compareTo(Schedule other) {
	return 0;
    }

}