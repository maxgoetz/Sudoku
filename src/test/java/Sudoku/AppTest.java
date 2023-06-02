package Sudoku;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import Sudoku.Model.*;
import org.junit.Test;

public class AppTest {
    @Test
    public void truth() {
        assertTrue(true);
    }

    @Test
    public void isSolved() {
        Puzzle puzzle0solved = new PuzzleImpl(SamplePuzzles.PUZZLE_0_SOLVED);
        PuzzleLibrary puzzleLibrary = new PuzzleLibraryImpl();
        puzzleLibrary.addPuzzle(puzzle0solved);
        Model model = new ModelImpl(puzzleLibrary);
        assertTrue(model.isSolved());
    }

    @Test
    public void placeNumber() {
        Puzzle puzzle0 = new PuzzleImpl(SamplePuzzles.PUZZLE_0);
        PuzzleLibrary puzzleLibrary = new PuzzleLibraryImpl();
        puzzleLibrary.addPuzzle(puzzle0);
        Model model = new ModelImpl(puzzleLibrary);
        model.setOpenValue(0, 4, 8);
        assertTrue(model.getOpenValue(0, 4) == 8);
    }

    @Test
    public void testIllegalArgument() {
        Puzzle puzzle0 = new PuzzleImpl(SamplePuzzles.PUZZLE_0);
        PuzzleLibrary puzzleLibrary = new PuzzleLibraryImpl();
        puzzleLibrary.addPuzzle(puzzle0);
        Model model = new ModelImpl(puzzleLibrary);
        try {
            model.setOpenValue(0, 0, 8);
            assertTrue(false);
        } catch (IllegalArgumentException e) {}
    }
}
