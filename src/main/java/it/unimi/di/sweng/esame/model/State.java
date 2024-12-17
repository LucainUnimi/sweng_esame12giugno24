package it.unimi.di.sweng.esame.model;

import java.util.List;

public interface State {
    List<Booking> getByTime();
    List<Booking> getByClassRoom();
    List<Booking> getOnlyC06();

    void addBook(Time t, ClassRoom c);

}
