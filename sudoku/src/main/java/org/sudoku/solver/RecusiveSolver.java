package org.sudoku.solver;

import org.sudoku.util.Const;
import org.sudoku.util.Utils;

/**
 * The solver below will use traditional recursive algorithm to solve the Sudoku puzzles
 * @author stallman wang
 */
public class RecusiveSolver implements Solver {

    @Override
    public boolean solve(int[][] puzzles) {
        Utils.checkPuzzles(puzzles);
        return solve(Const.INDEX_START_FROM, Const.INDEX_START_FROM, puzzles);
    }

    //recusive solve
    private boolean solve(int currRow, int currCol, int[][] puzzles) {

        //If the current row reach the last row, then skip to first row of next column.
        if (currRow == Const.DIMENSION) {
            currRow = 0;
            if (++currCol == Const.DIMENSION) {
                return true;
            }
        }
        // This cell been solved, skip filled puzzles
        if (puzzles[currRow][currCol] != Const.ZERO) {
            return solve(currRow + 1, currCol, puzzles);
        }

        //Iterate the value from 1 till the largest, check if any one can be filled in the puzzles
        for (int puzzleValue = Const.VALUE_START_FROM; puzzleValue <= Const.DIMENSION; ++puzzleValue) {
            //The boolean value indicate if the value is legal/suitable to be filled in current cell
            boolean isLegal = true;
            isLegal = Utils.isLegalPuzzleValue(puzzleValue, puzzles, currRow, currCol);
            if (isLegal) {
                puzzles[currRow][currCol] = puzzleValue;
                if (solve(currRow + 1, currCol, puzzles)) {
                    return true;
                }
            }
        }
        //Can't find the suitable solution
        puzzles[currRow][currCol] = Const.ZERO;
        return false;
    }

    @Override
    public String getSolverName() {
        return "Recusive Sudoku Solver";
    }
}
