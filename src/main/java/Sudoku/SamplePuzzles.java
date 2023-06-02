package Sudoku;

import Sudoku.Model.Cell;
import Sudoku.Model.CellImpl;
import Sudoku.Model.CellType;

public class SamplePuzzles {
    //guide

    public static Cell clue1 = new CellImpl(1, CellType.CLUE);
    public static Cell clue2 = new CellImpl(2, CellType.CLUE);
    public static Cell clue3 = new CellImpl(3, CellType.CLUE);
    public static Cell clue4 = new CellImpl(4, CellType.CLUE);
    public static Cell clue5 = new CellImpl(5, CellType.CLUE);
    public static Cell clue6 = new CellImpl(6, CellType.CLUE);
    public static Cell clue7 = new CellImpl(7, CellType.CLUE);
    public static Cell clue8 = new CellImpl(8, CellType.CLUE);
    public static Cell clue9 = new CellImpl(9, CellType.CLUE);
    public static Cell open0 = new CellImpl(0, CellType.OPEN);
    public static Cell open1 = new CellImpl(1, CellType.OPEN);
    public static Cell open2 = new CellImpl(2, CellType.OPEN);
    public static Cell open3 = new CellImpl(3, CellType.OPEN);
    public static Cell open4 = new CellImpl(4, CellType.OPEN);
    public static Cell open5 = new CellImpl(5, CellType.OPEN);
    public static Cell open6 = new CellImpl(6, CellType.OPEN);
    public static Cell open7 = new CellImpl(7, CellType.OPEN);
    public static Cell open8 = new CellImpl(8, CellType.OPEN);
    public static Cell open9 = new CellImpl(9, CellType.OPEN);




    public static Cell[][] PUZZLE_0 = {
            {clue5, clue9, clue7, clue6, open0, open0, clue4, clue8, open0},
            {open0, open0, open0, clue8, clue7, clue3, open0, clue9, open0},
            {open0, open0, clue3, open0, clue5, clue4, clue2, open0, open0},
            {open0, open0, clue9, open0, clue8, open0, open0, clue2, clue6},
            {clue6, clue3, open0, clue7, open0, open0, open0, open0, clue1},
            {open0, clue1, clue5, clue3, open0, open0, clue7, open0, open0},
            {clue7, clue5, clue1, open0, clue6, open0, open0, clue3, open0},
            {clue9, open0, open0, clue5, clue3, clue1, open0, open0, open0},
            {open0, clue6, open0, open0, open0, open0, open0, clue1, clue8},
    };

    public static Cell[][] PUZZLE_0_SOLVED = {
            {clue5, clue9, clue7, clue6, clue1, clue2, clue4, clue8, clue3},
            {clue2, clue4, clue6, clue8, clue7, clue3, clue1, clue9, clue5},
            {clue1, clue8, clue3, clue9, clue5, clue4, clue2, clue6, clue7},
            {clue4, clue7, clue9, clue1, clue8, clue5, clue3, clue2, clue6},
            {clue6, clue3, clue2, clue7, clue4, clue9, clue8, clue5, clue1},
            {clue8, clue1, clue5, clue3, clue2, clue6, clue7, clue4, clue9},
            {clue7, clue5, clue1, clue4, clue6, clue8, clue9, clue3, clue2},
            {clue9, clue2, clue8, clue5, clue3, clue1, clue6, clue7, clue4},
            {clue3, clue6, clue4, clue2, clue9, clue7, clue5, clue1, clue8},
    };
}
