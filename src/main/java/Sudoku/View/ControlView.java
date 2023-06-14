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
import javafx.scene.text.Font;

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
        Button nextButton = createButton("Next Puzzle");
        nextButton.setOnAction(
                (ActionEvent event) -> {
                    controller.clickNextPuzzle();
                });
        layout.getChildren().add(nextButton);

        createBuffer();

        // previous button
        Button previousButton = createButton("Previous Puzzle");
        previousButton.setOnAction(
                (ActionEvent event) -> {
                    controller.clickPrevPuzzle();
                });
        layout.getChildren().add(previousButton);

        createBuffer();

        // random puzzle button
        Button randomPuzzleButton = createButton("Random Puzzle");
        randomPuzzleButton.setOnAction(
                (ActionEvent event) -> {
                    controller.clickRandomPuzzle();
                });
        layout.getChildren().add(randomPuzzleButton);

        layout.setAlignment(Pos.TOP_CENTER);
        return layout;
    }

    private Button createButton(String buttonName) {
        Button button = new Button(buttonName);
        button.setFont(Font.font("Book Antiqua", 15));
        button.setMinSize(150, 80);
        button.setStyle("-fx-background-color: lightblue;");
        return button;
    }

    private void createBuffer() {
        VBox buffer = new VBox();
        Rectangle cell = new Rectangle(80, 80);
        cell.setFill(Color.WHITE);
        buffer.getChildren().add(cell);
        layout.getChildren().add(buffer);
    }
}

