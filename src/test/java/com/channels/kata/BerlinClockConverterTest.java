package com.channels.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BerlinClockConverterTest {

    @Test
    public void testBerlinClockConverterToCheckNullInputValues() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BerlinClockConverter(null));

        assertEquals("Please enter valid time", exception.getMessage());
    }
}