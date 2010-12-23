public class Information {

    private final int PENN_ID = 1;
    private final int PRIORITY = 2;
    private final int AVAILABLE_TIME = 3;
    private final int SCHEDULED_TIME = 4;
    private final int MISC = 5;

    private int kind;
    private String heading;
    private String value;

    public Information(String heading, String value) {
	this.heading = heading;
	this.value = value;
    }

    public String getHeading() {
	return heading;
    }

    public String getValue() {
	return value;
    }

    public String toString() {
	return heading + "\n" + value;
    }

}