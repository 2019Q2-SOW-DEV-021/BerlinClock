package com.channels.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Berlin Clock Converter")
class BerlinClockConverterTest {

    static Stream<String> getInvalidInputValues() {
        return Stream.of(null, "", "   ", "23", "12:60:60");
    }

    @ParameterizedTest
    @DisplayName("Test for invalid input values")
    @MethodSource("getInvalidInputValues")
    public void testBerlinClockConverterForInvalidInputValues(String digitalTime) {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BerlinClockConverter(digitalTime));

        assertEquals("Time must be in the format HH:mm:ss", exception.getMessage());
    }

    @Test
    @DisplayName("Test For Second light Turned On When second is even number")
    public void testBerlinClockConverterForEvenSecond() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:11:12");

        assertEquals("Y", berlinClockConverter.getBerlinClock().getSecond());
    }

    @Test
    @DisplayName("Test For Second light Turned On When second is Odd number")
    public void testBerlinClockConverterForOddSecond() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:11:11");

        assertEquals("0", berlinClockConverter.getBerlinClock().getSecond());
    }
}