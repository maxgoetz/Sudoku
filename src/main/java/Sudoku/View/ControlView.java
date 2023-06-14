package Sudoku.View;

import Sudoku.Controller.Controller;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ControlView implements FXComponent {
    private final Controller controller;
    private VBox layout;

    public ControlView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        layout = new VBox();
        layout.getStyleClass().add("control-layout");
        layout.setMinSize(300, 300);

        // next button
        Button nextButton = new Button("Next Puzzle");
        nextButton.setOnAction(
                (ActionEvent event) -> {
                    controller.clickNextPuzzle();
                });
        layout.getChildren().add(nextButton);

        createBuffer();

        // previous button
        Button previousButton = new Button("Previous Puzzle");
        previousButton.setOnAction(
                (ActionEvent event) -> {
                    controller.clickPrevPuzzle();
                });
        layout.getChildren().add(previousButton);

        createBuffer();

        // random puzzle button
        Button randomPuzzleButton = new Button("Random Puzzle");
        randomPuzzleButton.setOnAction(
                (ActionEvent event) -> {
                    controller.clickRandomPuzzle();
                });
        layout.getChildren().add(randomPuzzleButton);

        layout.setAlignment(Pos.CENTER);
        return layout;
    }

    private void createBuffer() {
        VBox buffer = new VBox();
        Rectangle cell = new Rectangle(100, 100);
        cell.setFill(Color.WHITE);
        buffer.getChildren().add(cell);
        layout.getChildren().add(buffer);
    }
}

