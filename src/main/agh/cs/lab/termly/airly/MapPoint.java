package agh.cs.lab.termly.airly;

import java.util.Arrays;

/**
 * Data about a map point as returned from the Airly API
 */
public class MapPoint {
    public Measurement currentMeasurements;
    public TimestampedMeasurement[] history;
    public TimestampedMeasurement[] forecast;



    @Override
    public String toString() {
        return "MapPoint{" +
                "currentMeasurements=" + currentMeasurements +
                ", history=" + Arrays.toString(history) +
                ", forecast=" + Arrays.toString(forecast) +
                '}';
    }
}
