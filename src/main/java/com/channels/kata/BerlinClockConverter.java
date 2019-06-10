package com.channels.kata;

public class BerlinClockConverter {
    public BerlinClockConverter(String digitalTime) {
        if (null == digitalTime) {
            throw new IllegalArgumentException("Please enter valid time");
        }
    }
}
