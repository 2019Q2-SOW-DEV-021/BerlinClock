package com.channels.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Berlin Clock Converter")
class BerlinClockConverterTest {

    public static final String TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS = "Time must be in the format HH:mm:ss";

    @Test
    @DisplayName("Test for a null input value")
    public void testBerlinClockConverterToCheckNullInputValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BerlinClockConverter(null));

        assertEquals(TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS, exception.getMessage());
    }

    @Test
    @DisplayName("Test for invalid input value")
    public void testBerlinClockConverterToCheckInvalidInputValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BerlinClockConverter("24:66"));

        assertEquals(TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS, exception.getMessage());
    }
}