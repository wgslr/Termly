package agh.cs.lab.termly.airly;

import java.util.Arrays;

/**
 * Pollution and weather data in a specific location
 * as returned by the Airly API.
 */
public class PointData implements IApiResponse {
    public final Measurement currentMeasurements;
    public final TimestampedMeasurement[] history;
    public final TimestampedMeasurement[] forecast;

    public PointData(Measurement currentMeasurements, TimestampedMeasurement[] history,
                     TimestampedMeasurement[] forecast) {
        this.currentMeasurements = currentMeasurements;
        this.history = history;
        this.forecast = forecast;
    }


    /**
     * Checks if returned data contain no values
     *
     * @return True iff there are no meaningfull data in the api response
     */
    @Override
    public boolean isEmpty() {
        return currentMeasurements == null || currentMeasurements.isEmpty()
                || history == null;
    }
}
