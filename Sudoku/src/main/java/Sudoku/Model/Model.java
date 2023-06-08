package Sudoku.Model;

public interface Model {
    void setOpenValue(int r, int c, int number);
    CellType getCellType(int r, int c);
    int getCellValue(int r, int c);
    boolean isClue(int r, int c);
    boolean isEmpty(int r, int c);
    boolean isSolved();
    void addObserver(ModelObserver observer);
    void removeObserver(ModelObserver observer);
    void resetPuzzle();
    void setActivePuzzleIndex(int index);
    int getActivePuzzleIndex();
    Puzzle getActivePuzzle();
    int getTotalPuzzles();
}
