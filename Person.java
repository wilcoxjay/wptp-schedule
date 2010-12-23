import java.util.Vector;

public class Person implements Comparable<Person> {

    private Information pennID;
    private Vector<Information> priority;
    private Vector<TimeSlot> availableTimes;
    private TimeSlot scheduledTime;
    private Vector<Information> misc;
I
    public Person(Information pennID, Vector<Information> priority, 
		  Vector<TimeSlot> availableTimes, Vector<Information> misc) {
	this.pennID = pennID;
	this.priority = priority;
	this.availableTimes = availableTimes;
	this.misc = misc;
    }

    public Person(Information pennID, Vector<Information> priority, 
		  Vector<TimeSlot> availableTimes, TimeSlot scheduledTime, 
		  Vector<Information> misc) {
	this.pennID = pennID;
	this.priority = priority;
	this.availableTimes = availableTimes;
	this.scheduledTime = scheduledTime;
	this.misc = misc;
    }

    public Vector<TimeSlot> getAvailableTimes() {
	return availableTimes;
    }

    public void scheduleTime(TimeSlot t) {
	scheduledTime = t;
    }

    public TimeSlot getScheduledTime() {
	return scheduledTime;
    }

    public int compareTo(Person other) {
	int thisValue = 0; 
	for (int i = priority.size() - 1; i >= 0; i--) {
	    if (priority.get(i)) {
		thisValue += (int) Math.pow(2, i);
	    }
	}
	int otherValue = 0;
	for (int i = other.priority.size() - 1; i >= 0; i--) {
	    if (other.priority.get(i)) {
		otherValue += (int) Math.pow(2, i);
	    }
	}
	return thisValue - otherValue;
    }

    public String toString() {
	String str = "";
	str += pennID.toString() + "\n";
	for (Information i : priority) {
	    str += i.toString() + "\n";
	}
	for (Information i : misc) {
	    str += i.toString() + "\n";
	}
	str += "Available Times:\n";
	for (TimeSlot t : availableTimes) {
	    str += t.toString() + ", ";
	}
	str += "\nScheduled Time:\n" + scheduledTime;
	return str;
	}

    public static void main(String[] args) {
	Vector<Boolean> aPriority = new Vector<Instruction>();
	aPriority.add(new Instruction(null, true));
	aPriority.add(true);
	Vector<Boolean> bPriority = new Vector<Boolean>();
	bPriority.add(true);
	bPriority.add(false);
	Person a = new Person(null, aPriority, null, null, null);
	Person b = new Person(null, bPriority, null, null, null);
	System.out.println(a.compareTo(b));
    }
    
}