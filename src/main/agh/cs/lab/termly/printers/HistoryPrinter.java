package agh.cs.lab.termly.printers;

import agh.cs.lab.termly.airly.PointData;

import java.awt.*;
import java.util.Arrays;

public class HistoryPrinter implements IPrinter {
    @Override
    public void print(PointData pointData) {
        Arrays.stream(pointData.history)
                .map(pd -> pd.measurements.pm25 + " " + pd.measurements.pm10)
                .forEach(System.out::println);
    }
}
