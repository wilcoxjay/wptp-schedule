/*
  Version 12/24
*/

import java.util.Vector;

public class Algorithm {

    /* Maybe works? */
    public static Schedule random(Vector<Person> people, 
				  Vector<TimeSlot> times) {
	Schedule s = new Schedule(people, times);
	
	for (Person p : people) {
	    
	    Vector<TimeSlot> availableTimes = 
		new Vector<TimeSlot>(p.getAvailableTimes());
	    
	    boolean done = false;	    
	    while (!done) {

		int index = (int) (Math.random() * availableTimes.size());
		TimeSlot t = availableTimes.get(index);

		if (s.canSchedule(p, t)) {
		    s.schedule(p, t);
		    done = true;
		} else {
		    availableTimes.remove(index);
		}
		
		if (availableTimes.size() == 0) {
		    done = true;
		}
	    }
	}
	return s;
    }
}