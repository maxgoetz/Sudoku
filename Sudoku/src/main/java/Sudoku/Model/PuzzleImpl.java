package Sudoku.Model;

public class PuzzleImpl implements Puzzle {
    private int[][] board;

    public PuzzleImpl(int[][] board) {
        if (board == null) {
            throw new IllegalArgumentException();
        }
        this.board = board.clone();
    }

    @Override
    public CellType getCellType(int r, int c) {
        verifyLocationParameters(r, c);
        if (board[r][c] > 10) {
            return CellType.CLUE;
        }
        return CellType.OPEN;
    }

    @Override
    public int getCellValue(int r, int c) {
        verifyLocationParameters(r, c);
        if (getCellType(r, c) == CellType.CLUE) {
            return board[r][c] - 10;
        }
        return board[r][c];
    }

    @Override
    public LocalPuzzle getLocalPuzzle(int r, int c) {
        verifyLocationParameters(r, c);
        if (((r - c) % 3) != 0) {
            throw new IllegalArgumentException();
        }
        int[] localPuzzle = {board[r-1][c-1], board[r-1][c], board[r-1][c+1],
                board[r][c-1], board[r][c], board[r][c+1],
                board[r+1][c-1], board[r+1][c], board[r+1][c+1]};
        return new LocalPuzzleImpl(localPuzzle);
    }

    @Override
    public void setOpenValue(int r, int c, int number) {
        if (getCellType(r, c) != CellType.OPEN) {
            throw new IllegalArgumentException();
        }
        verifyLocationParameters(r, c);
        verifyValueParameter(number);
        board[r][c] = number;
    }

    @Override
    public void resetPuzzle() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (getCellType(i, j) == CellType.OPEN) {
                    board[i][j] = (0);
                }
            }
        }
    }

    private void verifyLocationParameters(int r, int c) {
        if (r > 8 || r < 0 || c > 8 || c < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void verifyValueParameter(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException();
        }
    }
}
