package agh.cs.lab.termly.airly;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampedMeasurement implements IApiResponse {
    public String fromDateTime;
    public String tillDateTime;
    public Measurement measurements;

    @Override
    public String toString() {
        return "TimestampedMeasurement{" +
                "fromDateTime='" + fromDateTime + '\'' +
                ", tillDateTime='" + tillDateTime + '\'' +
                ", measurements=" + measurements +
                '}';
    }

    public LocalDateTime getFrom() {
        return LocalDateTime.parse(fromDateTime.substring(0, fromDateTime
                        .length() - 1), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }

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
        return measurements.isEmpty();
    }
}

