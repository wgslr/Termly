package agh.cs.lab.termly;

import org.junit.Test;

import static org.junit.Assert.*;

public class PollutionLevelTest {

    @Test
    public void getByCAQI() {
        assertEquals(PollutionLevel.VERY_LOW, PollutionLevel.getByCAQI(0));
        assertEquals(PollutionLevel.LOW, PollutionLevel.getByCAQI(49));
        assertEquals(PollutionLevel.MEDIUM, PollutionLevel.getByCAQI(50));
        assertEquals(PollutionLevel.VERY_HIGH, PollutionLevel.getByCAQI(101));
    }

}
