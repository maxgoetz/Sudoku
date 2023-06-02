package Sudoku.Model;

public class PuzzleImpl implements Puzzle {
    private Cell[][] board;

    public PuzzleImpl(Cell[][] board) {
        if (board == null) {
            throw new IllegalArgumentException();
        }
        this.board = board.clone();
    }

    @Override
    public CellType getCellType(int r, int c) {
        verifyParameters(r, c);
        return board[r][c].getCellType();
    }

    @Override
    public int getClueValue(int r, int c) {
        verifyParameters(r, c);
        if (board[r][c].getCellType() != CellType.CLUE) {
            throw new IllegalArgumentException();
        }
        return board[r][c].getCellValue();
    }

    @Override
    public int getOpenValue(int r, int c) {
        verifyParameters(r, c);
        if (board[r][c].getCellType() != CellType.OPEN) {
            throw new IllegalArgumentException();
        }
        return board[r][c].getCellValue();
    }

    @Override
    public LocalPuzzle getLocalPuzzle(int r, int c) {
        verifyParameters(r, c);
        if (((r - c) % 3) != 0) {
            throw new IllegalArgumentException();
        }
        Cell[] localPuzzle = {board[r-1][c-1], board[r-1][c], board[r-1][c+1],
                board[r][c-1], board[r][c], board[r][c+1],
                board[r+1][c-1], board[r+1][c], board[r+1][c+1]};
        return new LocalPuzzleImpl(localPuzzle);
    }

    @Override
    public void setOpenValue(int r, int c, int number) {
        if (board[r][c].getCellType() != CellType.OPEN) {
            throw new IllegalArgumentException();
        }
        verifyParameters(r, c);
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException();
        }
        board[r][c].setCellValue(number);
    }

    @Override
    public void resetPuzzle() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (getCellType(i, j) == CellType.OPEN) {
                    board[i][j].setCellValue(0);
                }
            }
        }
    }

    private void verifyParameters(int r, int c) {
        if (r > 8 || r < 0 || c > 8 || c < 0) {
            throw new IndexOutOfBoundsException();
        }
    }
}
