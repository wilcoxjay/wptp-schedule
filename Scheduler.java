import java.util.*;
import java.io.*;

public class Scheduler {

    public static void main(String[] args) throws FileNotFoundException {
	Scheduler s = new Scheduler();
	System.out.println(s);
	int i = 0;
    }

	
    private Vector<Person> people = new Vector<Person>();
    private Vector<TimeSlot> times = new Vector<TimeSlot>();

    public Scheduler() throws FileNotFoundException {
	parseFiles();
    }

    private void parseFiles() throws FileNotFoundException {
	Scanner in = new Scanner(new File("input.txt"));

	String[] heading = in.nextLine().split("\t");
	in.nextLine();
	in.nextLine();
	int timeIndex = indexOfTimes(heading);
	
	while (in.hasNextLine()) {
	    String[] boxes = in.nextLine().split("\t");

	    Vector<String> info = new Vector<String>();
	    for (int i = 0; i < timeIndex; i++) {
		info.add(heading[i] + "\n" + boxes[i]);
	    }

	    Vector<TimeSlot> availableTimes = new Vector<TimeSlot>();
	    for (int i = timeIndex; i < heading.length; i++) {
		String day = heading[i].substring(0, heading[i].indexOf(" "));
		String[] slots = boxes[i].split(", ");

		for (String slot : slots) {
		
		    TimeSlot t = new TimeSlot(day, slot);
		    if (!times.contains(t)) {
			times.add(t);
		    } else {
			t = times.get(times.indexOf(t));
		    }
		    availableTimes.add(t);
		}
	    }

	    people.add(new Person(info, availableTimes));	
	}
	    
    }

    private int indexOfTimes(String[] heading) {
	for (int i = 0; i < heading.length; i++) {
	    String box = heading[i];
	    if (box.startsWith("Monday") || box.startsWith("Tuesday") 
		|| box.startsWith("Wednesday") || box.startsWith("Thursday")
		|| box.startsWith("Friday") || box.startsWith("Saturday") 
		|| box.startsWith("Sunday")) {
		return i;
	    }
	}
	return -1;
    }

    public String toString() {
	String str = "";
	for (Person p : people) {
	    str += p.toString() + "\n";
	}
	return str;
    }

}