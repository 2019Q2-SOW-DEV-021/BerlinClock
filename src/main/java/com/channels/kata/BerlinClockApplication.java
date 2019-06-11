package com.channels.kata;

public class BerlinClockApplication {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Time must be in the format HH:mm:ss or HH:mm");
        }
        new BerlinClockApplication().launchBerlinClockConverter(args[0]);
    }

    public void launchBerlinClockConverter(String digitalTime) {
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(digitalTime);
        System.out.print(berlinClockConverter.getBerlinClock().toString());
    }
}
