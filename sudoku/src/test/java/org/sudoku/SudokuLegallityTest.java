package org.sudoku;

import org.junit.Assert;
import org.sudoku.util.Utils;
import org.sudoku.solver.FreeCellSolver;
import org.sudoku.solver.RecusiveSolver;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 *
 * @author stallman wang
 */
public class SudokuLegallityTest {

    static Sudoku sudoku;

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

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_execute_too_many_arguments() {
        String[] args = {"006", "290", "340",
            "000", "086", "092",
            "000", "070", "001",
            "100", "008", "070",
            "008", "020", "100",
            "090", "100", "008",
            "700", "030", "000",
            "510", "840", "000",
            "064", "200", "300",
            "000"};
        sudoku.execute(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_execute_null_parameters() {
        sudoku.execute(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_parse_invalid_parameters() {
        //The 4th parameter contain character, and suppose program only accet numeral value
        String[] args = {"006", "290", "340",
            "00A", "086", "092",
            "000", "070", "001",
            "100", "008", "070",
            "008", "020", "100",
            "090", "100", "008",
            "700", "030", "000",
            "510", "840", "000",
            "064"};
        sudoku.execute(args);
    }

    @Test
    public void should_parse_parameter_with_empty_value() {
        //The 7th parameter is empty
        String[] args = {"006", "290", "340",
            "000", "086", "092",
            "", "070", "001",
            "100", "008", "070",
            "008", "020", "100",
            "090", "100", "008",
            "700", "030", "000",
            "510", "840", "000",
            "064"};
        sudoku.execute(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_parse_parameter_with_unexpected_length_1() {
        //The 8th and 18th paramter only have 1 digit rather than 3 digits
        String[] args = {"006", "290", "340",
            "000", "086", "092",
            "000", "0", "001",
            "100", "008", "070",
            "008", "020", "100",
            "090", "100", "0",
            "700", "030", "000",
            "510", "840", "000",
            "064"};
        sudoku.execute(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_parse_parameter_with_unexpected_length_5() {
        //The 5th parameter contain 5 digits rather than 3 digits
        String[] args = {"006", "290", "340",
            "000", "08697", "092",
            "000", "070", "001",
            "100", "008", "070",
            "008", "020", "100",
            "090", "100", "008",
            "700", "030", "000",
            "510", "840", "000",
            "064"};
        sudoku.execute(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_parse_illegal_puzzles_same_box() {
        //Both 1st parameter and 4th paramter contain value 6, and these 2 paramters fall into
        // same box
        String[] args = {"006", "290", "340",
            "600", "086", "092",
            "000", "070", "001",
            "100", "008", "070",
            "008", "020", "100",
            "090", "100", "008",
            "700", "030", "000",
            "510", "840", "000",
            "064"};
        sudoku.execute(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_parse_illegal_puzzles_same_row() {
        //The last row have duplicated value
        String[] args = {"006", "290", "340",
            "000", "08697", "092",
            "000", "070", "001",
            "100", "008", "070",
            "008", "020", "100",
            "090", "100", "008",
            "700", "030", "000",
            "510", "840", "000",
            "064", "061"};
        sudoku.execute(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_parse_illegal_puzzles_same_col() {
        //The second column  have duplicated value
        String[] args = {"006", "290", "340",
            "000", "08697", "092",
            "000", "070", "001",
            "100", "008", "070",
            "008", "020", "100",
            "090", "100", "008",
            "700", "030", "000",
            "510", "840", "000",
            "064", "100"};
        sudoku.execute(args);
    }

    @Test
    public void should_check_illegal_puzzles_same_box() {
        //The cell value of last row and last column is 2,
        // At the same time, the cell of 8th row and 8th column is 2 - same value
        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 7},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {9, 6, 4, 7, 1, 2, 8, 5, 2}};
        Assert.assertFalse(Utils.isLegalPuzzles(cells));
    }

    @Test
    public void should_check_illegal_puzzles_same_col() {
        //The 1st column is illegal, the 2nd value and last value is duplicated - 3
        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 7},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {3, 6, 4, 7, 1, 2, 8, 5, 3}};
        Assert.assertFalse(Utils.isLegalPuzzles(cells));
    }

    @Test
    public void should_check_illegal_puzzles_same_row() {
        //The 1st row is illegal, the 1st value and last value is duplicated - 8
        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 8},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {9, 6, 4, 7, 1, 2, 8, 5, 3}};
        Assert.assertFalse(Utils.isLegalPuzzles(cells));
    }

    @Test
    public void should_check_illegal_puzzle_value_same_box() {

        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 0},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {9, 6, 4, 7, 1, 2, 8, 5, 3}};
        //Try to set 5 at the first row and last value, which is illegal (duplicated with value in same box)
        Assert.assertFalse(Utils.isLegalPuzzleValue(5, cells, 0, 8));
    }

    @Test
    public void should_check_illegal_puzzle_value_same_row() {

        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 0},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {9, 6, 4, 7, 1, 2, 8, 5, 3}};
        //Try to set 9 at the first row and last value, which is illegal (duplicated with value in same row)
        Assert.assertFalse(Utils.isLegalPuzzleValue(9, cells, 0, 8));
    }

    @Test
    public void should_check_illegal_puzzle_value_same_col() {

        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 0},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {9, 6, 4, 7, 1, 2, 8, 5, 3}};
        //Try to set 3 at the first row and last value, which is illegal (duplicated with value in same column)
        Assert.assertFalse(Utils.isLegalPuzzleValue(3, cells, 0, 8));
    }

    @Test
    public void should_check_legal_puzzles() {

        //legal sudoku puzzles as below
        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 7},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {9, 6, 4, 7, 1, 2, 8, 5, 3}};
        System.out.println(Utils.isLegalPuzzles(cells));
        Assert.assertTrue(Utils.isLegalPuzzles(cells));


    }

    @Test
    public void should_check_legal_puzzle_value() {

        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 0},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {9, 6, 4, 7, 1, 2, 8, 5, 3}};
        //Try to set 7 at the first row and last value, which is legal
        Assert.assertTrue(Utils.isLegalPuzzleValue(7, cells, 0, 8));


    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_check_illegal_puzzles_same_row() {
        //The 1st row is illegal, the 1st value and last value is duplicated - 8

        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 8},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {9, 6, 4, 7, 1, 2, 8, 5, 3}};
        Utils.checkPuzzles(cells);

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_check_illegal_puzzles_same_col() {
        //The 1st column is illegal, the 2nd value and last value is duplicated - 3
        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 7},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {3, 6, 4, 7, 1, 2, 8, 5, 3}};
        Utils.checkPuzzles(cells);

    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_while_check_illegal_puzzles_same_box() {
        //The cell value of last row and last column is 2,
        // At the same time, the cell of 8th row and 8th column is 2 - same value
        int[][] cells = {{8, 5, 6, 2, 9, 1, 3, 4, 7},
            {3, 7, 1, 4, 8, 6, 5, 9, 2},
            {2, 4, 9, 5, 7, 3, 6, 8, 1},
            {1, 2, 5, 3, 6, 8, 4, 7, 9},
            {4, 3, 8, 9, 2, 7, 1, 6, 5},
            {6, 9, 7, 1, 5, 4, 2, 3, 8},
            {7, 8, 2, 6, 3, 5, 9, 1, 4},
            {5, 1, 3, 8, 4, 9, 7, 2, 6},
            {9, 6, 4, 7, 1, 2, 8, 5, 2}};
        Utils.checkPuzzles(cells);

    }
}
