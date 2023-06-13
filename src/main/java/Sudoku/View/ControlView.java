package Sudoku.View;

import Sudoku.Controller.Controller;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ControlView implements FXComponent {
    private final Controller controller;
    private HBox layout;

    public ControlView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        layout = new HBox();
        layout.getStyleClass().add("control-layout");

        // next button
        Button nextButton = new Button("Next Puzzle");
        nextButton.setOnAction(
                (ActionEvent event) -> {
                    controller.clickNextPuzzle();
                });
        layout.getChildren().add(nextButton);

        // previous button
        Button previousButton = new Button("Previous Puzzle");
        previousButton.setOnAction(
                (ActionEvent event) -> {
                    controller.clickPrevPuzzle();
                });
        layout.getChildren().add(previousButton);

        // random puzzle button
        Button randomPuzzleButton = new Button("Random Puzzle");
        randomPuzzleButton.setOnAction(
                (ActionEvent event) -> {
                    controller.clickRandomPuzzle();
                });
        layout.getChildren().add(randomPuzzleButton);

        return layout;
    }
}
