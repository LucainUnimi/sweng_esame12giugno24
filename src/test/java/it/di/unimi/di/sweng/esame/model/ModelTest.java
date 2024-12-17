package it.di.unimi.di.sweng.esame.model;

import it.unimi.di.sweng.esame.presenter.Observer;
import it.unimi.di.sweng.esame.model.Booking;
import it.unimi.di.sweng.esame.model.ClassRoom;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.model.Time;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

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

    @Test
    void testOnlyC06() {
        Model model = new Model();
        model.addBook(new Time(10, 3), new ClassRoom("INGSW", "C10"));
        model.addBook(new Time(9, 3), new ClassRoom("INGSW", "C06"));
        model.addBook(new Time(8, 3), new ClassRoom("INGSW", "C08"));

        assertThat(model.getOnlyC06()).containsExactly(
                new Booking(new Time(9, 3), new ClassRoom("INGSW", "C06"))
        );
    }


    @Test
    void testOrderByClassRoomModel() {
        Model model = new Model();
        model.addBook(new Time(10, 3), new ClassRoom("INGSW", "C06"));
        model.addBook(new Time(9, 3), new ClassRoom("INGSW", "C09"));
        model.addBook(new Time(8, 3), new ClassRoom("INGSW", "C08"));

        assertThat(model.getByClassRoom()).containsExactly(
                new Booking(new Time(10, 3), new ClassRoom("INGSW", "C06")),
                new Booking(new Time(8, 3), new ClassRoom("INGSW", "C08")),
                new Booking(new Time(9, 3), new ClassRoom("INGSW", "C09"))
        );
    }

    @Test
    void testmodelObservable() {
        Observer<List<Booking>> obs1 = mock();
        Observer<List<Booking>> obs2 = mock();

        Model SUT = new Model();
        SUT.addObserver(obs1);
        SUT.addObserver(obs2);

        SUT.addBook(mock(Time.class), mock(ClassRoom.class));
        SUT.addBook(mock(Time.class), mock(ClassRoom.class));
        SUT.addBook(mock(Time.class), mock(ClassRoom.class));

        verify(obs1, times(3)).update(any());
        verify(obs2, times(3)).update(any());
    }
}
