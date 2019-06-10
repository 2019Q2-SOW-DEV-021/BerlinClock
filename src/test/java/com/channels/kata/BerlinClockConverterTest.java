package com.channels.kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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
    @DisplayName("Test invalid input values")
    @MethodSource("getInvalidInputValues")
    public void testBerlinClockConverterForInvalidInputValues(String digitalTime) {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                new BerlinClockConverter(digitalTime));

        assertEquals("Time must be in the format HH:mm:ss", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("Test Second value for all both even and odd number input")
    @CsvSource({"12:11:12,Y", "11:11:11,0"})
    public void testBerlinClockConverterForSecondValue(String digitalTime, String expectedSecondValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        assertEquals(expectedSecondValue, berlinClockConverter.getBerlinClock().getSecond());
    }

    @Test
    @DisplayName("Test Five hour row value for given time")
    public void testBerlinClockConverterForFiveHourRow() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("12:12:32");

        assertEquals("RR00", berlinClockConverter.getBerlinClock().getFiveHourRow());
    }

}