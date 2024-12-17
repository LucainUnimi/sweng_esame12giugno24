package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Booking;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Observable;
import it.unimi.di.sweng.esame.view.OutputView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static java.lang.Math.min;

public class OutputPresenter implements Observer<List<Booking>> {

    @NotNull private final OutputView view;
    @NotNull private final Strategy strategy;

    public OutputPresenter(@NotNull OutputView view, @NotNull Strategy strategy) {
        this.view = view;
        this.strategy = strategy;
    }

    @Override
    public void update(Observable<List<Booking>> observable) {
        Model model = (Model) observable;
        List<String> bookings = strategy.execute(model).subList(0, min(6, strategy.execute(model).size()));
        for (int i = 0; i < view.size(); i++) {
            view.set(i, i < bookings.size() ? bookings.get(i) : "");
        }

    }
}
