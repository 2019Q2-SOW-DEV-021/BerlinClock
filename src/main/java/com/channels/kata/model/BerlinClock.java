package com.channels.kata.model;

public class BerlinClock {
    private String second;
    private String fiveHourRow;
    private String singleHourRow;
    private String fiveMinuteRow;

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }

    public String getFiveHourRow() {
        return fiveHourRow;
    }

    public void setFiveHourRow(String fiveHourRow) {
        this.fiveHourRow = fiveHourRow;
    }

    public String getSingleHourRow() {
        return singleHourRow;
    }

    public void setSingleHourRow(String singleHourRow) {
        this.singleHourRow = singleHourRow;
    }

    public String getFiveMinuteRow() {
        return fiveMinuteRow;
    }

    public void setFiveMinuteRow(String fiveMinuteRow) {
        this.fiveMinuteRow = fiveMinuteRow;
    }
}
