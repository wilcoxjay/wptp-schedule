/*
  Version 12/23
  Just has random() copied and pasted from something old
*/

public class Algorithm {

    /* Copied and pasted from something old, very unfinished. */
    public static Schedule random(Vector<Person> people, 
				  Vector<TimeSlot> times) {
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

}