package agh.cs.lab.termly.airly;

/**
 * Measurement data as returned by the airly API
 */
public class Measurement implements IApiResponse {
    public final double airQualityIndex;
    public final double humidity;
    public final String measurementTime;
    public final double pm1;
    public final double pm10;
    public final double pm25;
    public final double pollutionLevel;
    public final double pressure;
    public final double temperature;
    public final double windDirection;
    public final double windSpeed;


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

    // Constructor required because of the final fields.
    // Inline constant defaults cannot be used as it prevents
    // proper updating of the values by the GSON deserializer
    // See https://docs.oracle.com/javase/specs/jls/se7/html/jls-17.html#jls-17.5.3
    public Measurement(double airQualityIndex, double humidity, String measurementTime,
                        double pm1, double pm10, double pm25, double pollutionLevel,
                        double pressure, double temperature, double windDirection,
                        double windSpeed) {


        this.airQualityIndex = airQualityIndex;
        this.humidity = humidity;
        this.measurementTime = measurementTime;
        this.pm1 = pm1;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.pollutionLevel = pollutionLevel;
        this.pressure = pressure;
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.windSpeed = windSpeed;
    }

}
