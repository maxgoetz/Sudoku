package Sudoku.View;

import Sudoku.Controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class MessageView implements FXComponent {
    private final Controller controller;
    private HBox layout;

    public MessageView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        layout = new HBox();
        Label startMessage = new Label("Welcome to Sudoku");
        startMessage.setFont(new Font("Verdana", 50));
        layout.getChildren().add(startMessage);
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
