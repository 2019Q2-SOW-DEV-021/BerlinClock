package com.channels.kata.model;

public class BerlinClock {
    private String second;
    private String fiveHourRow;
    private String singleHourRow;
    private String fiveMinuteRow;
    private String singleMinuteRow;

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

    public String getSingleMinuteRow() {
        return singleMinuteRow;
    }

    public void setSingleMinuteRow(String singleMinuteRow) {
        this.singleMinuteRow = singleMinuteRow;
    }

    @Override
    public String toString() {
        String newLine = System.getProperty("line.separator");
        StringBuilder berlinClockBuilder = new StringBuilder(this.getSecond());
        berlinClockBuilder.append(newLine);
        berlinClockBuilder.append(this.getFiveHourRow());
        berlinClockBuilder.append(newLine);
        berlinClockBuilder.append(this.getSingleHourRow());
        berlinClockBuilder.append(newLine);
        berlinClockBuilder.append(this.getFiveMinuteRow());
        berlinClockBuilder.append(newLine);
        berlinClockBuilder.append(this.getSingleMinuteRow());
        return berlinClockBuilder.toString();
    }
}
