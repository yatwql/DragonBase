package org.sudoku;

import org.sudoku.util.Utils;
import org.sudoku.solver.FreeCellSolver;
import org.sudoku.solver.RecusiveSolver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stallman wang
 */
public class SudokuTest {

    public SudokuTest() {
    }
    static Sudoku sudoku;
    //Incompleted parameters
    static final String[] params1 = {"006", "290", "340",
        "000", "086", "092",
        "000", "070", "001",
        "100", "008", "070",
        "008", "020", "100",
        "090", "100", "008",
        "700", "030", "000",
        "510", "840", "000",
        "064"};
    static final int[][] puzzleResult1 = {{8, 5, 6, 2, 9, 1, 3, 4, 7},
        {3, 7, 1, 4, 8, 6, 5, 9, 2},
        {2, 4, 9, 5, 7, 3, 6, 8, 1},
        {1, 2, 5, 3, 6, 8, 4, 7, 9},
        {4, 3, 8, 9, 2, 7, 1, 6, 5},
        {6, 9, 7, 1, 5, 4, 2, 3, 8},
        {7, 8, 2, 6, 3, 5, 9, 1, 4},
        {5, 1, 3, 8, 4, 9, 7, 2, 6},
        {9, 6, 4, 7, 1, 2, 8, 5, 3}};
    
    //Completed parameters, have 27 elements
    static final String[] params2 = {"800", "290", "307",
        "000", "086", "092",
        "000", "070", "001",
        "100", "008", "070",
        "008", "020", "100",
        "090", "100", "008",
        "700", "030", "000",
        "510", "840", "000",
        "964", "000", "003"};
    static final int[][] puzzleResult2 = {{8, 5, 6, 2, 9, 1, 3, 4, 7},
        {3, 7, 1, 4, 8, 6, 5, 9, 2},
        {2, 4, 9, 5, 7, 3, 6, 8, 1},
        {1, 2, 5, 3, 6, 8, 4, 7, 9},
        {4, 3, 8, 9, 2, 7, 1, 6, 5},
        {6, 9, 7, 1, 5, 4, 2, 3, 8},
        {7, 8, 2, 6, 3, 5, 9, 1, 4},
        {5, 1, 3, 8, 4, 9, 7, 2, 6},
        {9, 6, 4, 7, 1, 2, 8, 5, 3}};
    
    //Completed parameters, have 27 elements
    static final String[] params3 = {"530", "070", "000",
        "600", "195", "000",
        "098", "000", "060",
        "800", "060", "003",
        "400", "803", "001",
        "700", "020", "006",
        "060", "000", "280",
        "000", "419", "005",
        "000", "080", "079"};
    static final int[][] puzzleResult3 = {{5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}};

    //have empty parameter
    static final String[] params4 = {"006", "290", "340",
        "", "086", "092",
        "", "070", "001",
        "100", "008", "070",
        "008", "020", "100",
        "090", "100", "008",
        "700", "030", "",
        "510", "840", "",
        "064"};
    static final int[][] puzzleResult4 = {{8, 5, 6, 2, 9, 1, 3, 4, 7},
        {3, 7, 1, 4, 8, 6, 5, 9, 2},
        {2, 4, 9, 5, 7, 3, 6, 8, 1},
        {1, 2, 5, 3, 6, 8, 4, 7, 9},
        {4, 3, 8, 9, 2, 7, 1, 6, 5},
        {6, 9, 7, 1, 5, 4, 2, 3, 8},
        {7, 8, 2, 6, 3, 5, 9, 1, 4},
        {5, 1, 3, 8, 4, 9, 7, 2, 6},
        {9, 6, 4, 7, 1, 2, 8, 5, 3}};

    
    

  //Total with zero
    static final String[] params5 = {"", "", "",
        "000", "000", "000",
        "000", "000", "000",
        "000", "000", "000",
        "000", "000", "000",
        "000", "000", "000",
        "", "", "",
        "000", "000", "000",
        "000", "000", "000"};
    static final int[][] puzzleResult5_Recuisive =
       {
        {1, 4, 7, 2, 3, 8, 5, 6, 9},
        {2, 5, 8, 1, 6, 9, 3, 4, 7},
        {3, 6, 9, 4, 5, 7, 1, 2, 8},
        {4, 7, 1, 3, 8, 2, 6, 9, 5},
        {5, 8, 2, 6, 9, 1, 4, 7, 3},
        {6, 9, 3, 5, 7, 4, 2, 8, 1},
        {7, 1, 4, 8, 2, 3, 9, 5, 6},
        {8, 2, 5, 9, 1, 6, 7, 3, 4},
        {9, 3, 6, 7, 4, 5, 8, 1, 2}};

    static final int[][] puzzleResult5_FreeCell =
       {
        {1, 2, 3, 4, 5, 6, 7, 8, 9},
        {4, 5, 6, 7, 8, 9, 1, 2, 3},
        {7, 8, 9, 1, 2, 3, 4, 5, 6},
        {2, 1, 4, 3, 6, 5, 8, 9, 7},
        {3, 6, 5, 8, 9, 7, 2, 1, 4},
        {8, 9, 7, 2, 1, 4, 3, 6, 5},
        {5, 3, 1, 6, 4, 2, 9, 7, 8},
        {6, 4, 2, 9, 7, 8, 5, 3, 1},
        {9, 7, 8, 5, 3, 1, 6, 4, 2}};

        

    @BeforeClass
    public static void setUpClass() throws Exception {
        sudoku = new Sudoku();
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void should_parse_to_puzzles_from_param1() {
        String[] args = params1;
        int[][] expectCells = {{0, 0, 6, 2, 9, 0, 3, 4, 0},
            {0, 0, 0, 0, 8, 6, 0, 9, 2},
            {0, 0, 0, 0, 7, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 8, 0, 7, 0},
            {0, 0, 8, 0, 2, 0, 1, 0, 0},
            {0, 9, 0, 1, 0, 0, 0, 0, 8},
            {7, 0, 0, 0, 3, 0, 0, 0, 0},
            {5, 1, 0, 8, 4, 0, 0, 0, 0},
            {0, 6, 4, 0, 0, 0, 0, 0, 0}};


        assertArrayEquals(sudoku.parsePuzzles(args), expectCells);
    }

    @Test
    public void should_parse_to_puzzles_from_param2() {
        String[] args = params2;
        int[][] expectCells = {{8, 0, 0, 2, 9, 0, 3, 0, 7},
            {0, 0, 0, 0, 8, 6, 0, 9, 2},
            {0, 0, 0, 0, 7, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 8, 0, 7, 0},
            {0, 0, 8, 0, 2, 0, 1, 0, 0},
            {0, 9, 0, 1, 0, 0, 0, 0, 8},
            {7, 0, 0, 0, 3, 0, 0, 0, 0},
            {5, 1, 0, 8, 4, 0, 0, 0, 0},
            {9, 6, 4, 0, 0, 0, 0, 0, 3}};
        assertArrayEquals(sudoku.parsePuzzles(args), expectCells);
    }

   @Test
    public void should_parse_to_puzzles_from_param4() {
        String[] args = params4;
        int[][] expectCells = {{0, 0, 6, 2, 9, 0, 3, 4, 0},
            {0, 0, 0, 0, 8, 6, 0, 9, 2},
            {0, 0, 0, 0, 7, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 8, 0, 7, 0},
            {0, 0, 8, 0, 2, 0, 1, 0, 0},
            {0, 9, 0, 1, 0, 0, 0, 0, 8},
            {7, 0, 0, 0, 3, 0, 0, 0, 0},
            {5, 1, 0, 8, 4, 0, 0, 0, 0},
            {0, 6, 4, 0, 0, 0, 0, 0, 0}};


        assertArrayEquals(sudoku.parsePuzzles(args), expectCells);
    }

    @Test
    public void should_solve_puzzles_from_param1() {
        String[] args = params1;
        int[][] expectCells = puzzleResult1;
        int[][] puzzles = sudoku.parsePuzzles(args);
        sudoku.solvePuzzles(puzzles);
        Utils.checkPuzzles(puzzles);
        assertArrayEquals(puzzles, expectCells);
    }

    @Test
    public void should_solve_puzzles_from_param2() {
        String[] args = params2;
        int[][] expectCells = puzzleResult2;
        int[][] puzzles = sudoku.parsePuzzles(args);
        sudoku.solvePuzzles(puzzles);
        Utils.checkPuzzles(puzzles);
        assertArrayEquals(puzzles, expectCells);
    }

    @Test
    public void should_solve_puzzles_from_param3() {
        String[] args = params3;
        int[][] expectCells = puzzleResult3;
        int[][] puzzles = sudoku.parsePuzzles(args);
        sudoku.solvePuzzles(puzzles);
        Utils.checkPuzzles(puzzles);
        assertArrayEquals(puzzles, expectCells);
    }

    @Test
    public void should_solve_puzzles_from_param4() {
        String[] args = params4;
        int[][] expectCells = puzzleResult4;
        int[][] puzzles = sudoku.parsePuzzles(args);
        sudoku.solvePuzzles(puzzles);
        Utils.checkPuzzles(puzzles);
        assertArrayEquals(puzzles, expectCells);
    }


    @Test
    public void should_solve_puzzles_with_RecusiveSolver_from_params1() {
        //parse incomplete parameters
        String[] args = params1;
        int[][] expectCells = puzzleResult1;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new RecusiveSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }

        @Test
    public void should_solve_puzzles_with_RecusiveSolver_from_params2() {
        //parse complete parameters
        String[] args = params2;
        int[][] expectCells = puzzleResult2;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new RecusiveSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }

 

    @Test
    public void should_solve_puzzles_with_RecusiveSolver_from_params3() {
        //parse complete parameters
        String[] args = params3;
        int[][] expectCells = puzzleResult3;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new RecusiveSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }

@Test
    public void should_solve_puzzles_with_RecusiveSolver_from_params4() {
        //parse incomplete parameters
        String[] args = params4;
        int[][] expectCells = puzzleResult4;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new RecusiveSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }

    @Test
    public void should_solve_puzzles_with_RecusiveSolver_from_params5() {
        //parse complete parameters
        String[] args = params5;
        int[][] expectCells = puzzleResult5_Recuisive;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new RecusiveSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }

    @Test
    public void should_solve_puzzles_with_FreeCellSolver_from_params1() {
        //parse incomplete parameters
        String[] args = params1;
        int[][] expectCells = puzzleResult1;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new FreeCellSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }

        @Test
    public void should_solve_puzzles_with_FreeCellSolver_from_params2() {
        //parse complete parameters
        String[] args = params2;
        int[][] expectCells = puzzleResult2;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new FreeCellSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }


        @Test
    public void should_solve_puzzles_with_FreeCellSolver_from_params3() {
        //parse complete parameters
        String[] args = params3;
        int[][] expectCells = puzzleResult3;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new FreeCellSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }

      @Test
    public void should_solve_puzzles_with_FreeCellSolver_from_params4() {
        //parse incomplete parameters
        String[] args = params4;
        int[][] expectCells = puzzleResult4;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new FreeCellSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }

       @Test
    public void should_solve_puzzles_with_FreeCellSolver_from_params5() {
        //parse complete parameters
        String[] args = params5;
        int[][] expectCells = puzzleResult5_FreeCell;

        int[][] puzzles = sudoku.parsePuzzles(args);
        Utils.checkPuzzles(puzzles);
        sudoku.setSolver(new FreeCellSolver());
        sudoku.solvePuzzles(puzzles);

        assertArrayEquals(puzzles, expectCells);
    }


    @Test
    public void should_execute_with_FreeCellSolver_from_params3() {
        String[] args = params3;
        sudoku.execute(args, new FreeCellSolver());
    }

    @Test
    public void should_execute_with_RecusiveSolver_from_params3() {
        String[] args = params3;
        sudoku.execute(args, new RecusiveSolver());
    }


    @Test
    public void should_execute_with_FreeCellSolver_from_params4() {
        String[] args = params4;
        sudoku.execute(args, new FreeCellSolver());
    }

    @Test
    public void should_execute_with_RecusiveSolver_from_params4() {
        String[] args = params4;
        sudoku.execute(args, new RecusiveSolver());
    }

    @Test
    public void should_execute_with_FreeCellSolver_from_params5() {
        String[] args = params5;
        sudoku.execute(args, new FreeCellSolver());
    }

    @Test
    public void should_execute_with_RecusiveSolver_from_params5() {
        String[] args = params5;
        sudoku.execute(args, new RecusiveSolver());
    }
}
