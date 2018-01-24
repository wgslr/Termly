package agh.cs.lab.termly.printers;

import agh.cs.lab.termly.PollutionLevel;
import agh.cs.lab.termly.airly.Measurement;
import agh.cs.lab.termly.airly.PointData;

public class DetailsPrinter implements IPrinter {
    @Override
    public void print(PointData pointData) {
        Measurement data = pointData.currentMeasurements;

        String asciiArt = PollutionLevel.getByCAQI(new Double(data.airQualityIndex).intValue())
                .toAsciiArt();

        String information = String.format("PM2.5: %.0f μg/m^3\n" +
                        "PM10: %.2f μg/m^3\n" +
                        "Temperature: %.2f °C\n" +
                        "Pressure: %.1f hPa\n" +
                        "Humidity: %.0f%%\n" +
                        "Air Quality Index: %.2f\n" +
                        "%s",

                data.pm25, data.pm10, data.temperature,
                data.pressure / 100, data.humidity, data.airQualityIndex, asciiArt);

        System.out.println(information);
    }
}
