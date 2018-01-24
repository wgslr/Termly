package agh.cs.lab.termly;

import java.util.Arrays;
import java.util.Comparator;

public enum PollutionLevel {
    VERY_LOW(0),
    LOW(25),
    MEDIUM(50),
    HIGH(75),
    VERY_HIGH(100);

    public final int minLevel;

    PollutionLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public static PollutionLevel getByCAQI(int level) {
        return Arrays.stream(PollutionLevel.values())
                .sorted(Comparator.comparing((PollutionLevel x) -> x.minLevel).reversed())
                .filter(x -> level >= x.minLevel)
                .findFirst()
                .orElse(VERY_LOW);
    }

    public String toAsciiArt() {
        switch (this) {
            case VERY_HIGH:
            case HIGH:
                return "   .-.   \n" +
                        "  (0.0)  \n" +
                        "'=.|m|.='\n" +
                        ".='`\"``=.\n";
            case MEDIUM:
                return "~_~_~_~_~_~\n" +
                        "_~_~_~_~_~_\n";
            case LOW:
                return "  \\  /     \n" +
                        "_ /\"\".-.   \n" +
                        "  \\_(   ). \n" +
                        "  /(___(__)\n";
            case VERY_LOW:
                return "  \\   /  \n" +
                        "   .-.   \n" +
                        "― (   ) ―\n" +
                        "   `-’   \n" +
                        "  /   \\  \n";

        }

        return "";
    }
}
