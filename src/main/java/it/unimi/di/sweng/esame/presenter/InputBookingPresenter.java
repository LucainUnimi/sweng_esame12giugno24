package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Time;
import it.unimi.di.sweng.esame.view.InputView;
import org.jetbrains.annotations.NotNull;

public class InputBookingPresenter implements InputPresenter{

    @NotNull private final InputView view;

    public InputBookingPresenter(@NotNull InputView view) {
        this.view = view;
        view.addHandlers(this);
    }

    @Override
    public void action(@NotNull String times, @NotNull String classRoom) {
        String[] time = times.split(",");
        try {
            Time t = new Time(Integer.parseInt(time[0]), Integer.parseInt(time[1]));
        } catch (IllegalArgumentException e) {
            view.showError(e.getMessage());
        }
    }
}
