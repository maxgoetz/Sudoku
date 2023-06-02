package Sudoku.Model;

import java.util.ArrayList;
import java.util.List;

public class PuzzleLibraryImpl implements PuzzleLibrary {
    private final List<Puzzle> puzzles;

    public PuzzleLibraryImpl() {
        this.puzzles = new ArrayList<>();
    }

    @Override
    public void addPuzzle(Puzzle puzzle) {
        if (puzzle == null) {
            throw new IllegalArgumentException();
        }
        puzzles.add(puzzle);
    }

    @Override
    public Puzzle getPuzzle(int index) {
        if (index > puzzles.size()) {
            throw new IllegalArgumentException();
        }
        return puzzles.get(index);
    }

    @Override
    public int size() {
        return puzzles.size();
    }
}
