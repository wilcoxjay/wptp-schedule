import java.util.Vector;

public class TimeSlot {

    private String day;
    private String slot;
    private int capacity;
    private int peopleScheduled;

    public TimeSlot(String day, String slot) {
	this.day = day;
	this.slot = slot;
	capacity = 3;
	peopleScheduled = 0;
    }
    
    public boolean equals(TimeSlot other) {
	return day.equals(other.day) && slot.equals(other.slot);
    }

    public boolean canAddPerson() {
	return peopleScheduled < capacity;
    }

    public void addPerson(Person p) {
	peopleScheduled++;
    }

    public String toString() {
	return day + " " + slot;
    }

}