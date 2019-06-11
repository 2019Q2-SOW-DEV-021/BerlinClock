package com.channels.kata;

import com.channels.kata.model.BerlinClock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Berlin Clock Application")
public class BerlinClockApplicationTest {

    @Test
    @DisplayName("Test Berlin Clock with no arguments value")
    public void testBerlinClockApplicationFor() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BerlinClockApplication.main(new String[]{}));

        assertEquals("Time must be in the format HH:mm:ss or HH:mm", exception.getMessage());
    }

    @Test
    @DisplayName("Test Berlin Clock with null as arguments value")
    public void testBerlinClockApplicationForInvalidInputTime() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BerlinClockApplication.main(new String[]{null}));

        assertEquals("Time must be in the format HH:mm:ss or HH:mm", exception.getMessage());
    }

    @Test
    @DisplayName("Test Berlin Clock for given time")
    public void testBerlinClockApplicationForGivenTime() {
        ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutputStream));

        BerlinClockApplication.main(new String[]{"02:45:54"});

        BerlinClock berlinClock = new BerlinClock();
        berlinClock.setSecond("Y");
        berlinClock.setFiveHourRow("0000");
        berlinClock.setSingleHourRow("RR00");
        berlinClock.setFiveMinuteRow("YYRYYRYYR00");
        berlinClock.setSingleMinuteRow("0000");
        Assertions.assertEquals(berlinClock.toString(), consoleOutputStream.toString());
    }

}