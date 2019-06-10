package com.channels.kata;

import com.channels.kata.model.BerlinClock;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BerlinClockConverter {

    public static final String TIME_MUST_BE_IN_THE_FORMAT_HH_MM_SS = "Time must be in the format HH:mm:ss";
    private BerlinClock berlinClock;

    public BerlinClockConverter(String digitalTime) {
        final LocalTime parsedDigitalTime = parseDigitalTime(digitalTime);
        convertDigitalTimeToBerlinTime(parsedDigitalTime);
    }

    private void convertDigitalTimeToBerlinTime(LocalTime parsedDigitalTime) {
        berlinClock = new BerlinClock();
        berlinClock.setSecond((parsedDigitalTime.getSecond() % 2) == 0 ? "Y" : "0");
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
