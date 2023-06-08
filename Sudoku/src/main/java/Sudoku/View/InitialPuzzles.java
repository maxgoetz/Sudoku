package Sudoku.View;

import Sudoku.Model.PuzzleImpl;
import Sudoku.Model.PuzzleLibrary;
import Sudoku.Model.PuzzleLibraryImpl;
import Sudoku.SamplePuzzles;

public class InitialPuzzles {
    private static PuzzleLibrary puzzleList;

    public static PuzzleLibrary create() {
        if (puzzleList == null) {
            puzzleList = new PuzzleLibraryImpl();
            puzzleList.addPuzzle(new PuzzleImpl(SamplePuzzles.PUZZLE_0));
        }
        return puzzleList;
    }
}
