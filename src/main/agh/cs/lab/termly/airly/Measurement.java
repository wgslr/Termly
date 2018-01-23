package agh.cs.lab.termly.airly;

/**
 * Measurement data as returned by the airly API
 */
public class Measurement {
    public double airQualityIndex = -500;
    public double humidity = -500;
    public String measurementTime = "string";
    public double pm1 = -500;
    public double pm10 = -500;
    public double pm25 = -500;
    public double pollutionLevel = -500;
    public double pressure = -500;
    public double temperature = -500;
    public double windDirection = -500;
    public double windSpeed = -500;

    @Override
    public String toString() {
        return "Measurement{" +
                "airQualityIndex=" + airQualityIndex +
                ", humidity=" + humidity +
                ", measurementTime='" + measurementTime + '\'' +
                ", pm1=" + pm1 +
                ", pm10=" + pm10 +
                ", pm25=" + pm25 +
                ", pollutionLevel=" + pollutionLevel +
                ", pressure=" + pressure +
                ", temperature=" + temperature +
                ", windDirection=" + windDirection +
                ", windSpeed=" + windSpeed +
                "}\n";
    }
}
