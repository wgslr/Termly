package agh.cs.lab.termly.airly;

/**
 * Measurement data as returned by the airly API
 */
public class Measurement implements IApiResponse {
    public double airQualityIndex;
    public double humidity;
    public String measurementTime;
    public double pm1;
    public double pm10;
    public double pm25;
    public double pollutionLevel;
    public double pressure;
    public double temperature;
    public double windDirection;
    public double windSpeed;


    /**
     * Checks if this data set was created for not available data.
     */
    public boolean isEmpty() {
        return airQualityIndex == 0 &&
                humidity == 0 &&
                pm1 == 0 &&
                pm10 == 0 &&
                pm25 == 0 &&
                pollutionLevel == 0 &&
                pressure == 0 &&
                temperature == 0 &&
                windDirection == 0 &&
                windSpeed == 0;
    }

}
