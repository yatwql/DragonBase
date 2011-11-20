package org.sudoku.solver;

/**
 * Strategy interface to solve soduku puzzles
 * @author stallman wang
 */
public interface Solver {
    /**
     * Entry method
     * @param puzzles
     * @return
     */
     public boolean solve(int[][] puzzles);
     /**
      * Get name of solver
      * @return
      */
     public String getSolverName();
}
