import java.util.*;

public class ScheduleGenerator {

    private HashMap<Person, TimeSlot> schedule;
    private Vector<Person> people;
    private Vector<TimeSlot> times;

    public ScheduleGenerator(Vector<Person> people, Vector<TimeSlot> times) {
	this.people = Collection.sort(people);
	this.times = times;
    }

    public ScheduleGenerator(HashMap<Person, TimeSlot> schedule, 
			     Vector<Person> people, Vector<TimeSlot> times) {
	this.schedule = schedule;
	this.people = Collection.sort(people);
	this.times = times;
    }

    private Schedule getRandomSchedule() {
	private HashMap<Person, TimeSlot> s = new HashMap<Person, TimeSlot>();
	for (Person p : people) {
	    Vector<TimeSlot> availableTimes = 
		new Vector<TimeSlot>(p.getAvailableTimes());
	    boolean done = false;
	    while (!done) {
		int index = (int) (Math.random() * availableTimes.size());
		if (availableTimes.get(index).canAddPerson()) {
		    s.put(p, availableTimes.get(index));
		    done = true;
		} else {
		    availableTimes.remove(index);
		}
		if (availableTimes.size() == 0) {
		    done = true;
		}
	    }
	}
	return new Schedule(s, people, times);
    }

    public getPeopleExcluded() {
	return people.size() - schedule.size();
    }

}