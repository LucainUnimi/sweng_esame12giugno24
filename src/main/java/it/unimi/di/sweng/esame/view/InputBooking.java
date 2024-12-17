package it.unimi.di.sweng.esame.view;

import it.unimi.di.sweng.esame.presenter.InputPresenter;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

public class InputBooking extends Region implements InputView {

    private final @NotNull TextField time = new TextField();
    private final @NotNull TextField classRoom = new TextField();
    private final @NotNull Button addButton = new Button("Book");
    private final @NotNull Label error = new Label("");


    public InputBooking() {
        setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

        time.setPromptText("start,duration");
        classRoom.setPromptText("course,classroom");

        time.setPrefColumnCount(10);
        classRoom.setPrefColumnCount(15);
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(time, 0, 0);
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.add(classRoom, 1, 0);
        grid.add(addButton, 2, 0);
        grid.add(error, 0, 1);

        this.getChildren().add(grid);
    }

    public void addHandlers(@NotNull InputPresenter presenter) {
        addButton.setOnAction(eh -> presenter.action(time.getText(), classRoom.getText()));
    }

    @Override
    public void showError(@NotNull String s) {
        error.setText(s);
        setBackground(new Background(new BackgroundFill(Color.YELLOW, new CornerRadii(5.0), Insets.EMPTY)));
    }

    @Override
    public void showSuccess() {
        error.setText("");
        time.clear();
        classRoom.clear();
        setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, new CornerRadii(5.0), Insets.EMPTY)));
    }
}
