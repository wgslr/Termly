package agh.cs.lab.termly.printers;

import agh.cs.lab.termly.airly.Measurement;
import agh.cs.lab.termly.airly.PointData;

public class DetailsPrinter implements IPrinter {
    @Override
    public void print(PointData pointData) {
        Measurement data = pointData.currentMeasurements;
        String information = String.format("CAQI: %.2f\n" +
                        "PM2.5: %.0f μg/m^3\n" +
                        "PM10: %.2f μg/m^3\n" +
                        "Temperature: %.2f °C\n" +
                        "Pressure: %.1f hPa\n" +
                        "Humidity: %.0f%%",
                data.airQualityIndex, data.pm25, data.pm10, data.temperature,
                data.pressure / 100, data.humidity);

        System.out.println(information);
    }
}
