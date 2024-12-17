package it.unimi.di.sweng.esame.model;

import java.util.List;

public class Model implements State{
    @Override
    public List<Booking> getByTime() {
        return List.of();
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

    }
}
