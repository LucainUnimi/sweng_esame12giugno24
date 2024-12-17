package it.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.model.Model;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Strategy {
    List<String> execute(@NotNull Model model);
}
