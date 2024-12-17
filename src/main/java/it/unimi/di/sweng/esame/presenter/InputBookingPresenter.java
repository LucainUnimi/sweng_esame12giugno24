package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Time;
import it.unimi.di.sweng.esame.view.InputView;
import org.jetbrains.annotations.NotNull;

public class InputBookingPresenter implements InputPresenter{

    @NotNull private final InputView view;
    @NotNull private final Model model;

    public InputBookingPresenter(@NotNull InputView view, @NotNull Model model) {
        this.view = view;
        this.model = model;
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
