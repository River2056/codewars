package codewars;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * TicTacToeCheckerTest
 */
class TicTacToeCheckerTest {

    @Test
    void testTicTacToeChecker() {
        assertEquals(-1, TicTacToeChecker.isSolved(new int[][] {
            {0, 0, 1},
            {0, 1, 2},
            {2, 1, 0}
        }));

        assertEquals(1, TicTacToeChecker.isSolved(new int[][] {
            {1, 1, 1},
            {0, 2, 2},
            {0, 0, 0},
        }));
    }
}
