package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Observable;

public interface Observer<T> {
    void update(Observable<T> observable);
}
