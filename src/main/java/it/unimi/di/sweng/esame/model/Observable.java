package it.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.presenter.Observer;
import org.jetbrains.annotations.NotNull;


import java.util.List;

public interface Observable<T> {
    void addObserver(@NotNull Observer<List<Booking>> observer);
    void notifyObservers();

    T getByTime();
    T getByClassRoom();
    T getOnlyC06();
}
