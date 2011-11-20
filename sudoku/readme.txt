The program is aid to solve the Soduku puzzles, the populatr number puzzle.


Design behind the program:


The entry point of the program is still same as the original 
  class - org.sudoku.Sudoku with same usage in command line


For error-handling improvement 

Beside to improve the error-handling, the major concept introduce into the program is Solver.

Which make use of Strategy pattern, programer can develop new algorithm to solve the puzzles 
by implement the interface - org.sudoku.solver.Solver

Then inject the solver implementation into the Susoku program before it solve the puzzles.

The default Solver/algorithm is the traditional recursive algorithm - org.sudoku.solver.RecusiveSolver



Class Description:

org.sudoku.Sudoku  -  Entry point of the program
org.sudoku.Const   - Constants class
org.sudoku.Utils   - Utility class
org.sudoku.solver.Solver  - Interface class, programmer can develop new algorithm to solve the puzzles by implement this interface
org.sudoku.solver.RecusiveSolver - Default Solver/algorithm in the program to solve the puzzles, use traditional recursive algorithm
org.sudoku.solver.FreeCellSolver - The solver use an algorithm that I call free cell algorithm

org.sudoku.SudokuLegallityTest - Test Case class, it's majority to test the checking/error-handling  methods of Sudoku program
org.sudoku.SudokuTest - Test Case class to test Sudoku program
