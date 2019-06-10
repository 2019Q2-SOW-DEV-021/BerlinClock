package com.channels.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Berlin Clock Converter")
class BerlinClockConverterTest {

    @Test
    @DisplayName("Test for a null input value")
    public void testBerlinClockConverterToCheckNullInputValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BerlinClockConverter(null));

        assertEquals("Please enter valid time", exception.getMessage());
    }

    @Test
    @DisplayName("Test for invalid input value")
    public void testBerlinClockConverterToCheckInvalidInputValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BerlinClockConverter("24:66"));

        assertEquals("Time must be in the format HH:mm:ss", exception.getMessage());
    }
}