package Sudoku.View;

import Sudoku.Model.Model;
import Sudoku.Model.ModelImpl;
import Sudoku.Model.PuzzleLibrary;
import Sudoku.Controller.ControllerImpl;
import Sudoku.Controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class AppLauncher extends Application {
    @Override
    public void start(Stage stage) {

        // model
        PuzzleLibrary puzzles = InitialPuzzles.create();
        Model model = new ModelImpl(puzzles);

        // controller
        Controller controller = new ControllerImpl(model);

        // view
        AppView view = new AppView(controller, stage);

        Scene scene = new Scene(view.render());

        stage.setScene(scene);

        model.addObserver(
                (Model m) -> {
                    scene.setRoot(view.render());
                    stage.sizeToScene();
                });

        stage.setTitle("Sudoku");
        stage.show();
    }
}
