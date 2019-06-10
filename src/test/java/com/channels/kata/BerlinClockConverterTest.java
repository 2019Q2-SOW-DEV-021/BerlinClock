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

        assertEquals("Time must be in the format HH:mm:ss or HH:mm", exception.getMessage());
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

    @ParameterizedTest
    @DisplayName("Test Single hour row value for all possible combinations")
    @CsvSource({"00:12:10,0000", "01:02:02,R000", "02:03:12,RR00", "03:24:34,RRR0", "04:32:23,RRRR"})
    public void testBerlinClockConverterForSingleHourRow(String digitalTime, String expectedSingleHourRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        assertEquals(expectedSingleHourRowValue, berlinClockConverter.getBerlinClock().getSingleHourRow());
    }

    @ParameterizedTest
    @DisplayName("Test Five minute hour row value for all possible combinations")
    @CsvSource({"05:05,Y0000000000", "05:10,YY000000000", "16:16,YYR00000000", "16:22,YYRY0000000", "16:27,YYRYY000000", "16:30,YYRYYR00000", "16:35,YYRYYRY0000", "16:41,YYRYYRYY000", "16:46,YYRYYRYYR00", "16:51,YYRYYRYYRY0", "16:59,YYRYYRYYRYY"})
    public void testBerlinClockConverterForFiveMinuteRow(String digitalTime, String expectedFiveMinuteRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        assertEquals(expectedFiveMinuteRowValue, berlinClockConverter.getBerlinClock().getFiveMinuteRow());

    }

    @ParameterizedTest
    @DisplayName("Test Single Minute row value for all possible combinations")
    @CsvSource({"11:00,0000", "01:01,Y000", "02:02,YY00", "03:03,YYY0", "04:04,YYYY"})
    public void testBerlinClockConverterForSingleMinuteRow(String digitalTime, String expectedSinleMinuteRowValue) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);

        assertEquals(expectedSinleMinuteRowValue, berlinClockConverter.getBerlinClock().getSingleMinuteRow());

    }

    @Test
    @DisplayName("Test Textual representation of berlin clock for given input time")
    public void testBerlinClockConverterForGivenTimeInTextualRepresentation() {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter("08:18:34");

        assertEquals("Y\n" +
                "R000\n" +
                "RRR0\n" +
                "YYR00000000\n" +
                "YYY0", berlinClockConverter.getBerlinClock().toString());

    }
}