package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Model implements State{

    @NotNull private final List<Booking> bookings = new ArrayList<>();

    @Override
    public List<Booking> getByTime() {
        return bookings;
    }

    @Override
    public List<Booking> getByClassRoom() {
        return List.of();
    }

    @Override
    public List<Booking> getOnlyC06() {
        return List.of();
    }

    public void addBook(Time t, ClassRoom c) {
        bookings.add(new Booking(t, c));
    }
}
