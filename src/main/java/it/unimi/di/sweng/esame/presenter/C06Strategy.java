package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Booking;
import it.unimi.di.sweng.esame.model.Model;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class C06Strategy implements Strategy {
    public static final C06Strategy INSTANCE = new C06Strategy();

    @Override
    public List<String> execute(@NotNull Model model) {
        List<String> strings = new ArrayList<>();
        for(Booking booking: model.getByClassRoom()) {
            strings.add(booking.toString().replace(":C06", ""));
        }
        return strings;
    }
}
