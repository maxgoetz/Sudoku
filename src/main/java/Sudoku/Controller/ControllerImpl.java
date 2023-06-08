package Sudoku.Controller;

import Sudoku.Model.CellType;
import Sudoku.Model.Model;
import Sudoku.Model.ModelObserver;
import Sudoku.Model.Puzzle;

import java.util.Random;

public class ControllerImpl implements Controller {
    private Model model;

    public ControllerImpl(Model model) {
        this.model = model;
    }

    @Override
    public void clickNextPuzzle() {
        try {
            model.setActivePuzzleIndex(model.getActivePuzzleIndex() + 1);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Override
    public void clickPrevPuzzle() {
        try {
            model.setActivePuzzleIndex(model.getActivePuzzleIndex() - 1);
        } catch (IndexOutOfBoundsException e) {
        }
    }

    @Override
    public void clickRandomPuzzle() {
        Random random = new Random();
        int index = random.nextInt(model.getTotalPuzzles());
        while (index == model.getActivePuzzleIndex()) {
            index = random.nextInt(model.getTotalPuzzles());
        }
        model.setActivePuzzleIndex(index);
    }

    @Override
    public void clickResetPuzzle() {
        model.resetPuzzle();
    }

    @Override
    public void changeCellValue(int r, int c, int number) {
        model.setOpenValue(r, c, number);
    }

    @Override
    public boolean isClue(int r, int c) {
        return model.getCellType(r, c).equals(CellType.CLUE);
    }

    @Override
    public boolean isOpen(int r, int c) {
        return model.getCellType(r, c).equals(CellType.OPEN);
    }

    @Override
    public boolean isSolved() {
        return model.isSolved();
    }

    @Override
    public Puzzle getActivePuzzle() {
        return model.getActivePuzzle();
    }

    @Override
    public void addModelObserver(ModelObserver observer) {
        model.addObserver(observer);
    }
}
