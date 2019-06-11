package com.channels.kata;

public class BerlinClockApplication {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Time must be in the format HH:mm:ss or HH:mm");
        }
        BerlinClockConverter berlinClockConverter = new BerlinClockConverter(args[0]);
        System.out.print(berlinClockConverter.getBerlinClock().toString());
    }
}
