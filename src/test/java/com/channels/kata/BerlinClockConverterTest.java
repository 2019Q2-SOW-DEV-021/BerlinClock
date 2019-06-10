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

    @ParameterizedTest
    @DisplayName("Test Five hour row value for all possible combinations")
    @CsvSource({"01:12:32,0000", "05:33:22,R000", "11:12:34,RR00", "15:12:23,RRR0", "21:11:11,RRRR"})
    public void testBerlinClockConverterForFiveHourRow(String digitalTime, String expectedFiveHourRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        assertEquals(expectedFiveHourRowValue, berlinClockConverter.getBerlinClock().getFiveHourRow());
    }

    @Test
    @DisplayName("Test Single hour row value for given input time")
    public void testBerlinClockConverterForSingleHourRow() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("10:12:10");

        assertEquals("0000", berlinClockConverter.getBerlinClock().getSingleHourRow());
    }

}