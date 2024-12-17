package it.di.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.presenter.InputBookingPresenter;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.view.InputView;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestPresenter {

    @Test
    void testStartError() {
        InputView view = mock();
        InputBookingPresenter SUT = new InputBookingPresenter(view, mock());
        SUT.action("7,3", "INGSW,C06");
        verify(view).showError("Illegal start time");
    }

    @Test
    void testPresentValidBook() {
        Model model = mock();
        InputBookingPresenter SUT = new InputBookingPresenter(mock(), mock());
        SUT.action("8,3", "INGSW,C06");
        verify(model).addBook(any(), any());
    }
}
