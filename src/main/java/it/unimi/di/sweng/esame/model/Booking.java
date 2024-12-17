package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

public record Booking(@NotNull Time time, @NotNull ClassRoom classRoom) {
    @Override
    public String toString() {
        return time + " " + classRoom;
    }
}
