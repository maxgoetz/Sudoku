package Sudoku.Controller;

import Sudoku.Model.ModelObserver;
import Sudoku.Model.Puzzle;

public interface Controller {
    void clickNextPuzzle();
    void clickPrevPuzzle();
    void clickRandomPuzzle();
    void clickResetPuzzle();
    void changeCellValue(int r, int c, int number);
    boolean isClue(int r, int c);
    boolean isOpen(int r, int c);
    boolean isSolved();
    Puzzle getActivePuzzle();
    void addModelObserver(ModelObserver observer);

}
