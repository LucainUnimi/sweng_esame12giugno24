package it.di.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.model.Booking;
import it.unimi.di.sweng.esame.model.ClassRoom;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Time;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ModelTest {
    @Test
    void testModel() {
        Model model = new Model();
        model.addBook(new Time(8, 3), new ClassRoom("INGSW", "C06"));

        assertThat(model.getByTime()).contains(new Booking(new Time(8, 3), new ClassRoom("INGSW", "C06")));
    }

    @Test
    void testOrderByTimeModel() {
        Model model = new Model();
        model.addBook(new Time(10, 3), new ClassRoom("INGSW", "C10"));
        model.addBook(new Time(9, 3), new ClassRoom("INGSW", "C09"));
        model.addBook(new Time(8, 3), new ClassRoom("INGSW", "C08"));

        assertThat(model.getByTime()).containsExactly(
                new Booking(new Time(8, 3), new ClassRoom("INGSW", "C08")),
                new Booking(new Time(9, 3), new ClassRoom("INGSW", "C09")),
                new Booking(new Time(10, 3), new ClassRoom("INGSW", "C10"))
        );
    }
}
