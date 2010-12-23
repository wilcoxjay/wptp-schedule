import java.util.Vector;

/* 
   Version 12/23
   Does it need to keep track of which people are scheduled? I currently only
   keeps track of the number. 
*/

public class TimeSlot {

    private String day;
    private String slot;
    private int capacity;

    public TimeSlot(String day, String slot, int capacity) {
	this.day = day;
	this.slot = slot;
	this.capacity = capacity;
    }

    public boolean canSchedulePerson() {
	return capacity > 0;
    }

    public void schedulePerson() {
	capacity--;
    }

    public String toString() {
	return day + " " + slot;
    }

}