package agh.cs.lab.termly.airly;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents measurement decorated with a beginning and end time.
 */
public class TimestampedMeasurement implements IApiResponse {
    private final String fromDateTime;
    private final String tillDateTime;
    public final Measurement measurements;

    public TimestampedMeasurement(String fromDateTime, String tillDateTime, Measurement measurements) {
        this.fromDateTime = fromDateTime;
        this.tillDateTime = tillDateTime;
        this.measurements = measurements;
    }

    /**
     * @return Start time of the time period
     */
    public LocalDateTime getFrom() {
        return LocalDateTime.parse(fromDateTime.substring(0, fromDateTime
                        .length() - 1), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    /**
     * @return End time of the time period
     */
    public LocalDateTime getTill() {
        return LocalDateTime.parse(tillDateTime.substring(0, tillDateTime
                .length() - 1), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

    /**
     * Checks if returned data contain no values
     *
     * @return True iff there are no meaningfull data in the api response
     */
    @Override
    public boolean isEmpty() {
        return measurements == null || measurements.isEmpty();
    }
}

