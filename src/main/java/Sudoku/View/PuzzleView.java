package Sudoku.View;

import Sudoku.Controller.Controller;
import Sudoku.Model.Puzzle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class PuzzleView implements FXComponent {
    private final Controller controller;
    private BorderPane layout;
    private GridPane puzzle;
    private GridPane controls;
    private Integer[] lastClickedLocation;
    private int lastClickedValue;


    public PuzzleView(Controller controller) {
        this.controller = controller;
        layout = new BorderPane();
        puzzle = new GridPane();
        controls = new GridPane();
        lastClickedLocation = new Integer[2];
        lastClickedValue = 0;
    }

    @Override
    public Parent render() {
        layout.getStyleClass().add("puzzle-layout");
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                createLocalBoard(r, c);
            }
        }
        createControlPanel();
        layout.setCenter(puzzle);
        layout.setRight(controls);
        return layout;
    }
    private void createLocalBoard(int r, int c) {
        int blockSize = 50;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int cellValue = (controller.getCellValue(r + i, c + j));
                StackPane stackPane = findPaneType(r + i, c + j, cellValue, blockSize);
                puzzle.add(stackPane, c + j, r + i);
            }
        }
    }
    private void clickPuzzle(StackPane stackPane, int r, int c, int cellValue) {
        stackPane.setOnMouseClicked(event -> {
            if (lastClickedLocation[0] != null) {
                //can't use createStackPane in lambda function
                StackPane lastClickedPane = getStackPane(lastClickedLocation[0], lastClickedLocation[1]);
                Text text = createText(lastClickedValue);
                Rectangle cell = createCell(50, Color.WHITE);
                lastClickedPane.getChildren().set(1, cell);
                lastClickedPane.getChildren().set(2, text);
            }

            lastClickedValue = cellValue;
            lastClickedLocation[0] = r;
            lastClickedLocation[1] = c;

            Rectangle cell = createCell(50, Color.YELLOW);
            Text text = createText(cellValue);
            stackPane.getChildren().set(1, cell);
            if ((cellValue) != 0) {
                stackPane.getChildren().set(2, text);
            }
        });
    }
    private void createControlPanel() {
        createBuffer();
        int n = 1;
        for (int i = 1; i < 4; i++) {
            for (int j = 1; j < 4; j++) {
                StackPane stackpane = createControlStackPane(80, n);
                clickControl(stackpane, n);
                controls.add(stackpane, i, j);
                n++;
            }
        }
        //creating the special X pane for removing values from open cells
        StackPane xPane = createXStackPane(80, "X");
        clickControl(xPane, 0);
        controls.add(xPane, 2, 4);
    }
    private void clickControl(StackPane stackPane, int number) {
        stackPane.setOnMouseClicked(event -> {
            if (lastClickedLocation[0] == null) {
                return;
            }
            controller.changeCellValue(lastClickedLocation[0], lastClickedLocation[1], number);
            clearLastClickedLocation();
        });
    }

    private StackPane findPaneType(int r, int c, int cellValue, int blockSize) {
        StackPane stackPane;
        if (controller.isClue(r, c)) {
            stackPane = createStackPane(Color.BLACK, Color.LIGHTBLUE, blockSize, cellValue);
        } else {
            stackPane = createStackPane(Color.BLACK, Color.WHITE, blockSize, cellValue);
            clickPuzzle(stackPane, r, c, cellValue);
        }
        return stackPane;
    }

    private StackPane getStackPane(int r, int c) {
        StackPane result = null;
        for (Node node : puzzle.getChildren()) {
            if (puzzle.getRowIndex(node) == r && puzzle.getColumnIndex(node) == c) {
                result = (StackPane) node;
            }
        }
        return result;
    }

    private StackPane createStackPane(Color borderColor, Color cellColor, int size, int value) {
        StackPane stackpane = new StackPane();
        Rectangle border = createBorder(size, borderColor);
        Rectangle cell = createCell(size, cellColor);
        Text text = createText(value);
        stackpane.getChildren().addAll(border, cell, text);
        return stackpane;
    }

    private StackPane createXStackPane(int size, String string) {
        StackPane stackpane = new StackPane();
        Rectangle border = createBorder(size, Color.BLACK);
        Rectangle cell = createCell(size, Color.LIGHTBLUE);
        Text text = createText(string);
        stackpane.getChildren().addAll(border, cell, text);
        return stackpane;
    }
    private StackPane createControlStackPane(int size, int value) {
        StackPane stackpane = new StackPane();
        Rectangle border = createBorder(size, Color.BLACK);
        Rectangle cell = createCell(size, Color.LIGHTBLUE);
        Text text = createText(value);
        stackpane.getChildren().addAll(border, cell, text);
        return stackpane;
    }

    private Rectangle createBorder(int size, Color color) {
        Rectangle cell = new Rectangle(size, size);
        cell.setFill(color);
        return cell;
    }

    private Rectangle createCell(int size, Color color){
        Rectangle border = new Rectangle(size * .95, size * .95);
        border.setFill(color);
        return border;
    }

    private Text createText(String string) {
        Text text = new Text(string);
        text.setFont(Font.font("Book Antiqua", 30));
        return text;
    }
    private Text createText(int value) {
        String string = Integer.toString(value);
        string = (value == 0) ? "" : (string);
        Text text = new Text(string);
        text.setFont(Font.font("Book Antiqua", 30));
        return text;
    }

    private void createBuffer() {
        VBox buffer = new VBox();
        buffer.setPadding(new Insets(0, 10, 10, 10));
        buffer.setSpacing(10);
        controls.add(buffer, 0, 0);
    }
    private void clearLastClickedLocation() {
        lastClickedLocation[0] = null;
        lastClickedLocation[1] = null;
    }

//    private Line createVertLines() {
//        Line line = new Line();
//        line.setStartX(0);
//        line.setEndX(x);
//        line.setStartY(y);
//        line.setEndY(y + distance);
//        return line;
//    }

//    private void createHorizLine() {
//        Line line = new Line();
//        line.setStartY(150);
//        line.setEndY(150);
//        line.setStartX(0);
//        line.setEndX(450);
//        layout.getChildren().add(line);
//    }

//    private void addHorizontalLines(GridPane gridPane) {
//        int numRows = 3;
//        double rowHeight = 150;
//        double gridWidth = 9 * 50;
//
//        for (int row = 1; row < numRows; row++) {
//            Line line = new Line(0, row * rowHeight, gridWidth, row * rowHeight);
//            gridPane.getChildren().add(line);
//        }
//    }

//    private void addVerticalLines(GridPane gridPane) {
//        int numColumns = /* number of columns in your grid */;
//        double columnWidth = /* width of each column */;
//        double gridHeight = /* height of the GridPane */;
//
//        for (int column = 1; column < numColumns; column++) {
//            Line line = new Line(column * columnWidth, 0, column * columnWidth, gridHeight);
//            gridPane.getChildren().add(line);
//        }
//    }
}
