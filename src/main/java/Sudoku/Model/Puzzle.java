package Sudoku.Model;

public interface Puzzle {
    CellType getCellType(int r, int c);
    int getOpenValue(int r, int c);
    int getClueValue(int r, int c);
    LocalPuzzle getLocalPuzzle(int r, int c);
    void setOpenValue(int r, int c, int number);
    void resetPuzzle();
}
