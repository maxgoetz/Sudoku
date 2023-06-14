package Sudoku.View;


import Sudoku.Controller.Controller;
import Sudoku.Model.Model;
import Sudoku.Model.ModelObserver;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;

public class AppView implements ModelObserver {
    private final Controller controller;
    private Stage stage;

    public AppView(Controller controller, Stage stage) {
        this.controller = controller;
        this.stage = stage;
        controller.addModelObserver(this);
    }

    public Parent render() {
        BorderPane layout = new BorderPane();
        layout.setStyle("-fx-background-color: white;");

//        // start message view
        MessageView messageView = new MessageView(controller);
        layout.setTop(messageView.render());

//        // Is Winner view
        IsSolvedView isSolved = new IsSolvedView(controller);
        layout.setRight(isSolved.render());

//        // control view
        ControlView controlView = new ControlView(controller);
        layout.setLeft(controlView.render());

//        // puzzle view
        PuzzleView puzzleView = new PuzzleView(controller);
        layout.setCenter(puzzleView.render());

        Rectangle bottomBuffer = new Rectangle(60, 60);
        bottomBuffer.setFill(Color.WHITE);
        layout.setBottom(bottomBuffer);

        return layout;
    }

    @Override
    public void update(Model model) {
        Scene scene = new Scene(render());
        stage.setScene(scene);
    }
}
