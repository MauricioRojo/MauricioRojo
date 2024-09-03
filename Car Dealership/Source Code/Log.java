import java.time.LocalDateTime;

/**
 * Represents a log entry with activity information and timestamp.
 */
public class Log {

    /** The activity information associated with the log entry. */
    String activity = "";

    /** The date and time when the log entry was created. */
    LocalDateTime dateTime;

    /**
     * Constructs a new Log object with the specified activity and current timestamp.
     *
     * @param activity The activity information to be logged.
     */
    public Log(String activity) {
        this.activity = activity;
        dateTime = LocalDateTime.now();
    }

    /**
     * Gets the log entry in a formatted string containing timestamp and activity information.
     *
     * @return A string representation of the log entry with timestamp and activity.
     */
    public String get_log() {
        return dateTime + " " + activity;
    }
}