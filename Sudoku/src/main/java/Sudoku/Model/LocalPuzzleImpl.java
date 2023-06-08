package Sudoku.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalPuzzleImpl implements LocalPuzzle {
    private int[] cells;

    public LocalPuzzleImpl(int[] cells) {
        if (cells.length != 9) {
            throw new IllegalArgumentException();
        }
        this.cells = cells.clone();
    }

    @Override
    public boolean isSolved() {
        Map<Integer, Integer> cellMap = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            int cellValue = cells[i];
            if (cellValue > 10) {
                cellValue -= 10;
            }
            if (cellValue == 0) {
                return false;
            }
            if (cellMap.containsKey(cellValue)) {
                cellMap.put(cellValue, cellMap.get(cellValue) + 1);
            } else {
                cellMap.put(cellValue, 1);
            }
        }
        return cellMap.size() == 9;
    }
}
