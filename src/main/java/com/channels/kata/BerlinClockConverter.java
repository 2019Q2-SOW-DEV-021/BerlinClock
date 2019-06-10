package com.channels.kata;

import com.channels.kata.model.BerlinClock;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BerlinClockConverter {

    public static final String TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS = "Time must be in the format HH:mm:ss";
    public static final String NO_LIGHT = "0";
    public static final int MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW = 4;
    private BerlinClock berlinClock;

    public BerlinClockConverter(String digitalTime) {
        final LocalTime parsedDigitalTime = parseDigitalTime(digitalTime);
        convertDigitalTimeToBerlinTime(parsedDigitalTime);
    }

    private void convertDigitalTimeToBerlinTime(LocalTime parsedDigitalTime) {
        berlinClock = new BerlinClock();
        berlinClock.setSecond((parsedDigitalTime.getSecond() % 2) == 0 ? "Y" : NO_LIGHT);
        berlinClock.setFiveHourRow(generateFiveHourRowValue(parsedDigitalTime));
    }

    private String generateFiveHourRowValue(LocalTime parsedDigitalTime) {
        final int numberOfHoursLightsOn = parsedDigitalTime.getHour() / 5;
        StringBuilder hoursRowBuilder = new StringBuilder(StringUtils.repeat("R", numberOfHoursLightsOn));
        hoursRowBuilder.append(StringUtils.repeat(NO_LIGHT, (MAXIMUM_NUMBER_OF_LIGHTS_IN_HOUR_ROW - numberOfHoursLightsOn)));
        return hoursRowBuilder.toString();
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
