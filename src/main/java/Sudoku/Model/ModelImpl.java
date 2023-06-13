package Sudoku.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelImpl implements Model {
    private PuzzleLibrary puzzleLibrary;
    private int currentPuzzleIndex;
    private List<ModelObserver> activeModelObservers;
    private Map<Integer, LocalPuzzle> localPuzzles;
    private Puzzle currentPuzzle;

    public ModelImpl(PuzzleLibrary library) {
        if (library == null) {
            throw new IllegalArgumentException();
        }
        this.puzzleLibrary = library;
        currentPuzzleIndex = 0;
        activeModelObservers = new ArrayList<>();
        localPuzzles = new HashMap();
        currentPuzzle = puzzleLibrary.getPuzzle(currentPuzzleIndex);
    }

    private void createLocalPuzzles() {
        Puzzle currentPuzzle = puzzleLibrary.getPuzzle(currentPuzzleIndex);
        int throwaway = 0;
        for (int i = 1; i < 8; i += 3) {
            for (int j = 1; j < 8; j += 3) {
                localPuzzles.put(throwaway++, currentPuzzle.getLocalPuzzle(i, j));
            }
        }
    }

    @Override
    public void setActivePuzzleIndex(int index) {
        if (index < 0 || index >= puzzleLibrary.size()) {
            throw new IndexOutOfBoundsException();
        }
        currentPuzzleIndex = index;
        currentPuzzle = puzzleLibrary.getPuzzle(currentPuzzleIndex);
        notify(activeModelObservers);
    }

    @Override
    public void setOpenValue(int r, int c, int number) {
        verifyParameters(r, c, number);
        currentPuzzle.setOpenValue(r, c, number);
        notify(activeModelObservers);
    }

    @Override
    public CellType getCellType(int r, int c) {
        verifyParameters(r, c);
        return currentPuzzle.getCellType(r, c);
    }

    @Override
    public int getCellValue(int r, int c) {
        verifyParameters(r, c);
        return currentPuzzle.getCellValue(r, c);
    }

    @Override
    public boolean isClue(int r, int c) {
        verifyParameters(r, c);
        return currentPuzzle.getCellType(r, c) == CellType.CLUE;
    }

    @Override
    public boolean isEmpty(int r, int c) {
        verifyParameters(r, c);
        return currentPuzzle.getCellValue(r, c) == 0;
    }


    private boolean is3x3solved(int q) {
        verifyParameters(q);
        createLocalPuzzles();
        return localPuzzles.get(q).isSolved();
    }

    private boolean isRowSolved(int r) {
        verifyParameters(r);
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            int value = currentPuzzle.getCellValue(r, i);
            if (value == 0) {
                return false;
            }
            if (currentPuzzle.getCellType(r, i).equals(CellType.OPEN)) {
                if (numbers.containsKey(value)) {
                    return false;
                } else {
                    numbers.put(value, 1);
                }
            }
        }
        return true;
    }

    private boolean isColumnSolved(int c) {
        verifyParameters(c);
        Map<Integer, Integer> numbers = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            int value = currentPuzzle.getCellValue(i, c);
            if (value == 0) {
                return false;
            }
            if (currentPuzzle.getCellType(i, c).equals(CellType.OPEN)) {
                if (numbers.containsKey(value)) {
                    return false;
                } else {
                    numbers.put(value, 1);
                }
            }
        }
        return true;
    }

    @Override
    public boolean isSolved() {
        for (int i = 0; i < 9; i++) {
            if (!isColumnSolved(i) || !isRowSolved(i) || !is3x3solved(i)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void addObserver(ModelObserver observer) {
        activeModelObservers.add(observer);
        notify(activeModelObservers);
    }

    @Override
    public void removeObserver(ModelObserver observer) {
        activeModelObservers.remove(observer);
    }

    @Override
    public void resetCell(int r, int c) {
        currentPuzzle.resetCell(r, c);
    }

    @Override
    public int getActivePuzzleIndex() {
        return currentPuzzleIndex;
    }

    @Override
    public Puzzle getActivePuzzle() {
        return puzzleLibrary.getPuzzle(currentPuzzleIndex);
    }

    @Override
    public int getTotalPuzzles() {
        return puzzleLibrary.size();
    }

    private void verifyParameters(int r, int c, int number) {
        if (r < 0 || r > 8 || c < 0 || c > 8) {
            throw new IllegalArgumentException();
        }
        if (number > 9 || number < 0) {
            throw new IllegalArgumentException();
        }
    }

    private void verifyParameters(int r, int c) {
        verifyParameters(r, c, 1);
    }

    private void verifyParameters(int q) {
        verifyParameters(q, 1, 1);
    }

    private void notify(List<ModelObserver> modelObservers) {
        for (ModelObserver observer : modelObservers) {
            observer.update(this);
        }
    }
}
