package codewars;

/**
 * NumberOfTrailingZerosofNFactorial
 */
public class NumberOfTrailingZerosofNFactorial {

    public static int zeroes(int n) {
        if (n < 5)
            return 0;
        int sum = 0;
        int pow = 1;
        while (Math.pow(5, pow) < n) {
            sum += n / Math.pow(5, pow);
            pow++;
        }

        return sum;
    }

    public static int zeroes2(int n) {
        int res = 0;
        for (int i = 5; i <= n; i *= 5) {
            res += n / i;
        }
        return res;
    }
}
