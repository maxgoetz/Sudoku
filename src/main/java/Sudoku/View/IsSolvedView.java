package Sudoku.View;

import Sudoku.Controller.Controller;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class IsSolvedView implements FXComponent {
    private final Controller controller;
    private HBox layout;

    public IsSolvedView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Parent render() {
        layout = new HBox();
        layout.setMinSize(300, 300);
        Label solvedMessage = new Label("You solved \nthe puzzle!");
        solvedMessage.setVisible(false);
        solvedMessage.setFont(new Font(30));
        if (controller.isSolved()) {
            solvedMessage.setVisible(true);
        }
        layout.getChildren().add(solvedMessage);
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
