package com.channels.kata;

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
    @DisplayName("Test Berlin Clock invalid input value")
    public void testBerlinClockApplicationForInvalidInputTime() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                BerlinClockApplication.main(new String[]{null}));

        assertEquals("Time must be in the format HH:mm:ss or HH:mm", exception.getMessage());
    }

    @Test
    @DisplayName("Test Berlin clock for given digital time")
    public void testBerlinClockApplicationForGivenDigitalTime() {
        ByteArrayOutputStream consoleOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(consoleOutputStream));
        new BerlinClockApplication().launchBerlinClockConverter("02:45:54");


        Assertions.assertEquals("Y\n" +
                "0000\n" +
                "RR00\n" +
                "YYRYYRYYR00\n" +
                "0000", consoleOutputStream.toString());
    }
}