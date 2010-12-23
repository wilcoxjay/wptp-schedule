/* 
   Version 12/23
   Mostly done just needs:
   1. Methods to return each instance variable.
   2. Testing. 
*/


import java.util.Vector;

public class Person implements Comparable<Person> {
    
    private String name;
    private int pennID;
    private boolean[] priority;
    private Vector<TimeSlot> availableTimes;
    private TimeSlot scheduledTime;

    public Person(String name, int pennID, boolean[] priority,
		  Vector<TimeSlot> availableTimes) {
	this.name = name;
	this.pennID = pennID;
	this.priority = priority;
	this.availableTimes = availableTimes;
    }

    public Person(String name, int pennID, boolean[] priority,
		  Vector<TimeSlot> availableTimes, TimeSlot scheduledTime) {
	this.name = name;
	this.pennID = pennID;
	this.priority = priority;
	this.availableTimes = availableTimes;
	this.scheduledTime = scheduledTime;
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
	for (int i = this.priority.length - 1; i >= 0; i--) {
	    if (this.priority[i]) {
		thisValue += (int) Math.pow(2, i);
	    }
	}
	int otherValue = 0;
	for (int i = other.priority.length - 1; i >= 0; i--) {
	    if (other.priority[i]) {
		otherValue += (int) Math.pow(2, i);
	    }
	}
	return thisValue - otherValue;
    }

    public String toString() {
	String str = "Name:\n" + name + "\n";
	str += "Penn ID:\n" + pennID + "\n";
	str += "Priority:\n";
       	for (boolean i : priority) {
	    str += i + "\n";
	}
	str += "Available Times:\n";
	for (TimeSlot t : availableTimes) {
	    str += t.toString() + "\n";
	}
	str += "Scheduled Time:\n" + scheduledTime;
	return str;
    }

    /* Tester, not done. */
    public static void main(String[] args) {
	Person a = new Person("Bob", 4, new boolean[] {true, false}, null);
	Person b = new Person("Sarah", 5, new boolean[] {false, true}, null, null);
	System.out.println(a + "\n");
	System.out.println(b + "\n");
	System.out.println(a.compareTo(b));
    }
    
}