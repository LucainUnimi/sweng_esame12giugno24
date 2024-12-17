package it.unimi.di.sweng.esame;


import it.unimi.di.sweng.esame.presenter.*;
import it.unimi.di.sweng.esame.model.Model;
import it.unimi.di.sweng.esame.view.DisplayView;
import it.unimi.di.sweng.esame.view.InputBooking;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;


public class Main extends Application {
    public static final int VIEWSIZE = 6;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(@NotNull Stage primaryStage) {

        primaryStage.setTitle("Unimi Classroom Reservations");

        DisplayView byDateListing = new DisplayView(VIEWSIZE, "By Time");
        DisplayView byClassListing = new DisplayView(VIEWSIZE, "By Class");
        DisplayView onlyClassListing = new DisplayView(VIEWSIZE/2, "Only ClassRoom C06");

        InputBooking input = new InputBooking();

        GridPane gridPane = new GridPane();
        gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        gridPane.add(input, 0, 0);
        GridPane.setColumnSpan(input, GridPane.REMAINING);

        gridPane.add(byDateListing, 0, 1);
        gridPane.add(byClassListing, 1, 1);
        gridPane.add(onlyClassListing, 0, 2);
        GridPane.setColumnSpan(onlyClassListing, GridPane.REMAINING);

        Model model = new Model();
        model.addObserver(new OutputPresenter(byDateListing, TimeStrategy.INSTANCE));
        model.addObserver(new OutputPresenter(byClassListing, ClassRoomStrategy.INSTANCE));
        model.addObserver(new OutputPresenter(onlyClassListing, C06Strategy.INSTANCE));

        new InputBookingPresenter(input, model);

        model.notifyObservers();

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
