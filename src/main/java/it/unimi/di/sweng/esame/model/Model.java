package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.presenter.Observer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Model implements State, Observable<List<Booking>> {

    @NotNull private final List<Booking> bookings = new ArrayList<>();
    @NotNull private final List<Observer<List<Booking>>> observers = new ArrayList<>();

    @Override
    public void addObserver(@NotNull Observer<List<Booking>> observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(
                observer -> observer.update(this)
        );
    }

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
        notifyObservers();
    }
}
