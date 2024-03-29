package com.channels.kata;

import com.channels.kata.model.BerlinClock;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BerlinClockConverter {

    public static final String TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS = "Time must be in the format HH:mm:ss or HH:mm";
    public static final String NO_LIGHT = "0";
    public static final int MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW = 4;
    public static final String RED_LIGHT = "R";
    public static final int CONSTANT_FIVE = 5;
    public static final String YELLOW_LIGHT = "Y";
    public static final int MAXIMUM_NUMBER_OF_LIGHTS_IN_FIVE_MINUTE_ROW = 11;
    private BerlinClock berlinClock;

    public BerlinClockConverter(String digitalTime) {
        final LocalTime parsedDigitalTime = parseDigitalTime(digitalTime);
        convertDigitalTimeToBerlinTime(parsedDigitalTime);
    }

    private void convertDigitalTimeToBerlinTime(LocalTime parsedDigitalTime) {
        berlinClock = new BerlinClock();
        berlinClock.setSecond((parsedDigitalTime.getSecond() % 2) == 0 ? YELLOW_LIGHT : NO_LIGHT);
        berlinClock.setFiveHourRow(generateRowValue((parsedDigitalTime.getHour() / CONSTANT_FIVE), RED_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW));
        berlinClock.setSingleHourRow(generateRowValue((parsedDigitalTime.getHour() % CONSTANT_FIVE), RED_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW));
        berlinClock.setFiveMinuteRow(generateRowValue((parsedDigitalTime.getMinute() / CONSTANT_FIVE), YELLOW_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_FIVE_MINUTE_ROW).replace("YYY", "YYR"));
        berlinClock.setSingleMinuteRow(generateRowValue((parsedDigitalTime.getMinute() % CONSTANT_FIVE), YELLOW_LIGHT, MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW));
    }

    private String generateRowValue(int numberOfLightsOn, String lightColor, int maximumNoOfLightsInRow) {
        StringBuilder rowvalueBuilder = new StringBuilder(StringUtils.repeat(lightColor, numberOfLightsOn));
        rowvalueBuilder.append(StringUtils.repeat(NO_LIGHT, (maximumNoOfLightsInRow - numberOfLightsOn)));
        return rowvalueBuilder.toString();
    }

    private LocalTime parseDigitalTime(String digitalTime) {
        if (null == digitalTime) {
            throw new IllegalArgumentException(TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS);
        }
        try {
            return LocalTime.parse(digitalTime);
        } catch (DateTimeParseException dateTimeParseException) {
            throw new IllegalArgumentException(TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS);
        }
    }

    public BerlinClock getBerlinClock() {
        return this.berlinClock;
    }
}
