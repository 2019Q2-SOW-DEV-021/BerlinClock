package com.channels.kata;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class BerlinClockConverter {
    public BerlinClockConverter(String digitalTime) {
        if (null == digitalTime) {
            throw new IllegalArgumentException("Please enter valid time");
        }
        try {
            LocalTime.parse(digitalTime);
        } catch (DateTimeParseException dateTimeParseException) {
            throw new IllegalArgumentException("Time must be in the format HH:mm:ss");
        }
    }
}
