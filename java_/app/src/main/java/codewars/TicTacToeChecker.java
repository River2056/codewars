package codewars;

import java.util.Arrays;
import java.util.List;

public class TicTacToeChecker {

    public static int isSolved(int[][] board) {
        int rowA = check(board[0]);
        int rowB = check(board[1]);
        int rowC = check(board[2]);
        int colA = check(new int[] {board[0][0], board[1][0], board[2][0]});
        int colB = check(new int[] {board[0][1], board[1][1], board[2][1]});
        int colC = check(new int[] {board[0][2], board[1][2], board[2][2]});
        int diaA = check(new int[] {board[0][0], board[1][1], board[2][2]});
        int diaB = check(new int[] {board[0][2], board[1][1], board[2][0]});
        List<Integer> res = Arrays.asList(rowA, rowB, rowC, colA, colB, colC, diaA, diaB);
        if (res.stream().noneMatch(i -> i > 0)) {
            if (res.stream().filter(i -> i == 0).toList().size() == 8)
                return 0;
            else
                return -1;

        }
        return res.stream().filter(i -> i > 0).findFirst().orElse(-1);
    }

    private static int check(int[] arr) {
        if (Arrays.stream(arr).noneMatch(i -> i == 0)) {
            if (arr[0] == arr[1] && arr[0] == arr[2])
                return arr[0];
            else
                return 0;
        }
        return -1;
    }
}
