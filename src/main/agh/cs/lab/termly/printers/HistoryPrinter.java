package agh.cs.lab.termly.printers;

import agh.cs.lab.termly.airly.PointData;
import agh.cs.lab.termly.airly.TimestampedMeasurement;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Printer displaying history of measurements in reverse chronological order
 */
public class HistoryPrinter implements IPrinter {

    @Override
    public void print(PointData pointData) {
        System.out.println(formatHeader());
        Arrays.stream(pointData.history)
                .sorted(Comparator.comparing(TimestampedMeasurement::getFrom)
                        .reversed())
                .map(this::formatRow)
                .forEach(System.out::println);
    }

    private String formatHeader() {
        return String.format("%16s:\t%6s\t%6s", "Hour", "PM2.5", "PM10");
    }

    private String formatRow(TimestampedMeasurement entry) {
        LocalDateTime dateTime = entry.getFrom();
        return String.format("%tY-%tm-%td %tH:%tM:\t%6.2f\t%6.2f",
                dateTime, dateTime, dateTime, dateTime, dateTime,
                entry.measurements.pm25,
                entry.measurements.pm10);

    }

}
