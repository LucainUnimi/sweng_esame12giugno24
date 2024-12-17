package it.unimi.di.sweng.esame.model;

public record Time(int start, int duration) {
    public Time {
        if (start < 8 || start > 20) {
            throw new IllegalArgumentException("Illegal start time");
        }
        if (duration < 1 || duration > 3) {
            throw new IllegalArgumentException("Illegal duration");
        }
    }
}
