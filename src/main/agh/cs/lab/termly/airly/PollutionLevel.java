package agh.cs.lab.termly.airly;

public enum PollutionLevel {
    VERY_LOW(0),
    LOW(25),
    MEDIUM(50),
    HIGH(75),
    VERY_HIGH(100);


    private final int minLevel;

    PollutionLevel(int minLevel) {
        this.minLevel = minLevel;
    }
}
