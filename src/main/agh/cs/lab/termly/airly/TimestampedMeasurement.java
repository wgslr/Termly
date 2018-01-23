package agh.cs.lab.termly.airly;

public class TimestampedMeasurement {
    public String fromDateTime;
    public String tillDateTime;
    public Measurement measurements;

    @Override
    public String toString() {
        return "TimestampedMeasurement{" +
                "fromDateTime='" + fromDateTime + '\'' +
                ", tillDateTime='" + tillDateTime + '\'' +
                ", measurements=" + measurements +
                '}';
    }
}

