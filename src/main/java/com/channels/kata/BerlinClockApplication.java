package com.channels.kata;

public class BerlinClockApplication {

    public static void main(String[] args) {
        new BerlinClockApplication().launchBerlinClockConverter(args[0]);
    }

    public void launchBerlinClockConverter(String digitalTime) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);
        System.out.print(berlinClockConverter.getBerlinClock());
    }
}
