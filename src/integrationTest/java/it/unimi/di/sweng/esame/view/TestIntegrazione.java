package it.unimi.di.sweng.esame.view;

import it.unimi.di.sweng.esame.Main;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.assertj.core.util.introspection.FieldSupport;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.assertions.api.Assertions.assertThat;
import static org.testfx.util.NodeQueryUtils.hasText;


@ExtendWith(ApplicationExtension.class)
public class TestIntegrazione {
  private static final boolean HEADLESS = false;

  private Stage stage;
  private OutputView byTimeDisplay;
  private OutputView byClassDisplay;
  private OutputView onlyC06Display;
  private Label errorMessage;
  private TextField time;
  private TextField classroom;
  private Button button;

  @BeforeAll
  public static void setupSpec() {
    if (HEADLESS) System.setProperty("testfx.headless", "true");
  }

  @Start
  public void start(@NotNull Stage primaryStage) {

    Main m = new Main();
    m.start(primaryStage);

    stage = primaryStage;
    GridPane gp = (GridPane) primaryStage.getScene().getRoot();
    ObservableList<Node> view = gp.getChildren();

    InputBooking input = (InputBooking) view.get(0);
    byTimeDisplay = (DisplayView) view.get(1);
    byClassDisplay = (DisplayView) view.get(2);
    onlyC06Display = (DisplayView) view.get(3);

    time = FieldSupport.EXTRACTION.fieldValue("time", TextField.class, input);
    classroom = FieldSupport.EXTRACTION.fieldValue("classRoom", TextField.class, input);
    button = FieldSupport.EXTRACTION.fieldValue("addButton", Button.class, input);
    errorMessage = FieldSupport.EXTRACTION.fieldValue("error", Label.class, input);
  }

  private void book(String time, String classRoom, @NotNull FxRobot robot) {
    writeOnGui(robot, this.time, time);
    writeOnGui(robot, this.classroom, classRoom);
    robot.clickOn(button);
  }

  private void writeOnGui(@NotNull FxRobot robot, TextField input, String text) {
    robot.doubleClickOn(input);
    robot.write(text, 0);
  }

  //TODO: Add integration tests
  @Test
  public void testStartTimeFail(@NotNull FxRobot robot) {
    book("7,3", "INGSW,C06", robot);
    assertThat(errorMessage).hasText("Illegal start time");
  }

  @Test
  public void testStartOkDurationFail(@NotNull FxRobot robot) {
    book("8,3", "INGSW,C06", robot);
    assertThat(errorMessage).hasText("Illegal duration");
  }



}
