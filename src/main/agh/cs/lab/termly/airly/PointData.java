package agh.cs.lab.termly.airly;

import java.util.Arrays;

/**
 * Data about a map point as returned from the Airly API
 */
public class PointData implements IApiResponse {
    public Measurement currentMeasurements;
    public TimestampedMeasurement[] history;
    public TimestampedMeasurement[] forecast;


    /**
     * Checks if returned data contain no values
     *
     * @return True iff there are no meaningfull data in the api response
     */
    @Override
    public boolean isEmpty() {
        return currentMeasurements.isEmpty() &&
                Arrays.stream(history).allMatch(IApiResponse::isEmpty) &&
                Arrays.stream(forecast).allMatch(IApiResponse::isEmpty);
    }
}
