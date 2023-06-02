package Sudoku.Model;

public interface Cell {
    public CellType getCellType();
    public void setCellValue(int v);
    public int getCellValue();
}
