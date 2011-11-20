package org.sudoku.solver;

import org.sudoku.util.Const;
import org.sudoku.util.Utils;

/**
 *The solver below  use free cell algorithm to solve the Sudoku puzzles
 * @author stallman wang
 */
public class FreeCellSolver implements Solver {

    private static final int FREE_CELL_ROW_VALUE = 0;
    private static final int FREE_CELL_COL_VALUE = 1;

    @Override
    public boolean solve(int[][] puzzles) {
        Utils.checkPuzzles(puzzles);
        
        //Obtain a list of free cells from the puzzles
        int[][] freeCellList = getFreeCellList(puzzles);
        
        // index of free cell, Start from the first free cell
        int index = Const.INDEX_START_FROM;

        // Indicate whether the solution is found
        boolean found = false; 

        while (!found) {
            int currRow = freeCellList[index][FREE_CELL_ROW_VALUE];
            int currCol = freeCellList[index][FREE_CELL_COL_VALUE];
            if (puzzles[currRow][currCol] == Const.DFL_CELL_VALUE) {
                puzzles[currRow][currCol] = Const.VALUE_START_FROM; // Start with 1
            }

            if (Utils.isLegalPuzzleValue(puzzles[currRow][currCol], puzzles, currRow, currCol)) {
                
                if (index + 1 == freeCellList.length) { // No more free cells
                    found = true; // A solution is found
                } else { // Move to the next free cell
                    index++;
                }
            } else if (puzzles[currRow][currCol] < Const.DIMENSION) {
                // Check the next possible value
                puzzles[currRow][currCol] = puzzles[currRow][currCol] + 1; 
            } else { // puzzles[rowIndex][colIndex] is 9, backtrack
                while (puzzles[currRow][currCol] == Const.DIMENSION) {
                    // Reset to free cell
                    puzzles[currRow][currCol] = Const.DFL_CELL_VALUE; 
                    if (index == Const.INDEX_START_FROM) {
                        return false; // No possible value
                    }
                    index--; // Backtrack
                    currRow = freeCellList[index][FREE_CELL_ROW_VALUE];
                    currCol = freeCellList[index][FREE_CELL_COL_VALUE];
                }

                // Check the next possible value
                puzzles[currRow][currCol] = puzzles[currRow][currCol] + 1; 
            }
        }
        return true; // A solution is found
    }

    
    /**
     * Obtain a list of free cells from the puzzles
     * @param puzzles
     * @return
     */
    private int[][] getFreeCellList(int[][] puzzles) {
        // Determine the number of free cells
        int numberOfFreeCells = 0;
        for (int rowIndex = Const.INDEX_START_FROM; rowIndex < Const.DIMENSION; rowIndex++) {
            for (int colIndex = Const.INDEX_START_FROM; colIndex < Const.DIMENSION; colIndex++) {
                if (puzzles[rowIndex][colIndex] == Const.DFL_CELL_VALUE) {
                    numberOfFreeCells++;
                }
            }
        }

        // Store free cell positions into freeCellList
        int[][] freeCellList = new int[numberOfFreeCells][2];
        // index of free cell, Start from the first free cell
        int index = Const.INDEX_START_FROM;
        for (int rowIndex = Const.INDEX_START_FROM; rowIndex < Const.DIMENSION; rowIndex++) {
            for (int colIndex = Const.INDEX_START_FROM; colIndex < Const.DIMENSION; colIndex++) {
                if (puzzles[rowIndex][colIndex] == Const.DFL_CELL_VALUE) {
                    freeCellList[index][FREE_CELL_ROW_VALUE] = rowIndex;
                    freeCellList[index][FREE_CELL_COL_VALUE] = colIndex;
                    index = index + 1;
                }
            }
        }

        return freeCellList;
    }

   @Override
    public String getSolverName() {
        return "Free Cell Sudoku Solver";
    }
}
