package codewars;

import java.util.Arrays;

/**
 * CatchingCarMileageNumbers
 */
public class CatchingCarMileageNumbers {

    public static int isInteresting(int number, int[] awesomePhrases) {
        if (number < 98) 
            return 0;
        if (number < 100)
            return 1;
        boolean interestingNumber = findInterestingNumber(number, awesomePhrases);
        if (interestingNumber) {
            return 2;
        } else {
            for (int i = number + 1; i <= number + 2; i++) {
                interestingNumber = findInterestingNumber(i, awesomePhrases);
                if (interestingNumber)
                    return 1;
            }
        }
        return 0;
    }

    private static boolean findInterestingNumber(int n, int[] awesomePhrases) {
        return Arrays.asList(isAllZeroes(n), isAllDigitSame(n), isIncrementOrDecrement(n, true), isIncrementOrDecrement(n, false), isPalindrome(n), matchAwesomePhrases(n, awesomePhrases))
            .stream().anyMatch(b -> b);
    }

    private static boolean isAllZeroes(int num) {
        while (num % 10 == 0) {
            num /= 10;
        }
        return num < 10;
    }

    private static boolean isAllDigitSame(int num) {
        String numStr = String.valueOf(num);
        char prev = numStr.charAt(0);
        for (int i = 1; i < numStr.length(); i++) {
            if (numStr.charAt(i) != prev)
                return false;
        }
        return true;
    }

    private static boolean isIncrementOrDecrement(int num, boolean isIncrementing) {
        if (isIncrementing)
            return "1234567890".contains(String.valueOf(num));
        else
            return "9876543210".contains(String.valueOf(num));
    }

    private static boolean isPalindrome(int num) {
        int prev = 0;
        int curr = num;
        while (curr > 0) {
            int remainder = curr % 10;
            prev = (prev * 10 + remainder);
            curr /= 10;
        }
        return prev == num;
    }

    private static boolean matchAwesomePhrases(int num, int[] awesomePhrases) {
        return Arrays.stream(awesomePhrases).anyMatch(n -> num == n);
    }
}
