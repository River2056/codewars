package java_.com.river;

import java.util.Arrays;

public class MultiplicationTable {
    public static int[][] multiplicationTable(int n) {
        int[][] result = new int[n][n];
        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[0].length; j++)
                result[i][j] = (i + 1) * (j + 1);

        return result;
    }

    public static void main(String[] args) {
        int[][] result = multiplicationTable(3);
        Arrays.stream(result).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}
