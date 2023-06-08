package Sudoku.View;


import Sudoku.Controller.Controller;
import Sudoku.Model.Model;
import Sudoku.Model.ModelObserver;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppView implements ModelObserver {
    private final Controller controller;
    private Stage stage;

    public AppView(Controller controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
        controller.addModelObserver(this);
    }

    public Parent render() {
        VBox layout = new VBox();

//        // start message view
//        MessageView messageView = new MessageView(_controller);
//        layout.getChildren().add(messageView.render());
//
//        // current puzzle message view
//        CurrentPuzzleMessageView currentPuzzleMessageView = new CurrentPuzzleMessageView(_controller);
//        layout.getChildren().add(currentPuzzleMessageView.render());
//
//        // Is Winner view
//        IsWinnerMessageView isWinner = new IsWinnerMessageView(_controller);
//        layout.getChildren().add(isWinner.render());
//
//        // control view
//        ControlView controlView = new ControlView(_controller);
//        layout.getChildren().add(controlView.render());
//
//        // puzzle view
//        PuzzleView puzzleView = new PuzzleView(_controller);
//        layout.getChildren().add(puzzleView.render());

        return layout;
    }

    @Override
    public void update(Model model) {
        Scene scene = new Scene(render());
        stage.setScene(scene);
    }
}
