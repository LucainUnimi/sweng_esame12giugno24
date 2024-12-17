package it.unimi.di.sweng.esame.model;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Model implements State{

    @NotNull private final List<Booking> bookings = new ArrayList<>();

    @Override
    public List<Booking> getByTime() {
        return bookings.stream().sorted(
                (b1, b2) -> b1.time().compareTo(b2.time())
        ).toList();
    }

    @Override
    public List<Booking> getByClassRoom() {
        return bookings.stream().sorted(
                (b1, b2) -> b1.classRoom().compareTo(b2.classRoom())
        ).toList();
    }

    @Override
    public List<Booking> getOnlyC06() {
        return bookings.stream().filter(
                b -> b.classRoom().classRoom().equals("C06")
        ).toList();
    }

    public void addBook(Time t, ClassRoom c) {
        bookings.add(new Booking(t, c));
    }
}
