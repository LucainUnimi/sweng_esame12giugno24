package it.di.unimi.di.sweng.esame.presenter;

import it.unimi.di.sweng.esame.presenter.InputBookingPresenter;
import it.unimi.di.sweng.esame.view.InputView;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestPresenter {

    @Test
    void testAction() {
        InputView view = mock();
        InputBookingPresenter SUT = new InputBookingPresenter(view);
        SUT.action("7,3", "C06");

        verify(view).showError("Illegal start time");
    }
}
