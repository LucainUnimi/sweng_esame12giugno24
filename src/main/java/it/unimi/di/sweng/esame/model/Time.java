package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

public record Time(int start, int duration) implements Comparable<Time> {
    public Time {
        if (start < 8 || start > 20) {
            throw new IllegalArgumentException("Illegal start time");
        }
        if (duration < 1 || duration > 3) {
            throw new IllegalArgumentException("Illegal duration");
        }
    }

    @Override
    public int compareTo(@NotNull Time o) {
        if (start == o.start) {
            return Integer.compare(duration, o.duration);
        }
        return Integer.compare(start, o.start);
    }

    @Override
    public String toString() {
        return start + " - " + start + duration;
    }
}
