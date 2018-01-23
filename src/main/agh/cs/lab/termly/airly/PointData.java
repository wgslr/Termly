package agh.cs.lab.termly.airly;

import java.util.Arrays;

/**
 * Data about a map point as returned from the Airly API
 */
public class PointData {
    public Measurement currentMeasurements;
    public TimestampedMeasurement[] history;
    public TimestampedMeasurement[] forecast;



    @Override
    public String toString() {
        return "PointData{" +
                "currentMeasurements=" + currentMeasurements +
                ", history=" + Arrays.toString(history) +
                ", forecast=" + Arrays.toString(forecast) +
                '}';
    }
}
