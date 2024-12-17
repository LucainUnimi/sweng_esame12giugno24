package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Booking;
import it.unimi.di.sweng.esame.model.Model;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class TimeStrategy implements Strategy{

    public static final TimeStrategy INSTANCE = new TimeStrategy();

    @Override
    public List<String> execute(@NotNull Model model) {
        List<String> strings = new ArrayList<>();
        for(Booking booking: model.getByClassRoom()) {
            strings.add(booking.toString());
        }
        return strings;
    }
}
