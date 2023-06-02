package Sudoku.Model;

public class CellImpl implements Cell {
    private int value;
    private CellType cellType;

    public CellImpl(int value, CellType cellType) {
        this.value = value;
        this.cellType = cellType;
    }

    public int getCellValue() {
        return value;
    }

    public void setCellValue(int v) {
        value = v;
    }

    public CellType getCellType() {
        return cellType;
    }
}
