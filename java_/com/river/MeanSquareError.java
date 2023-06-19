package java_.com.river;

public class MeanSquareError {

    public static double solution(int[] arr1, int[] arr2) {
        double sum = 0.0;
        for (int i = 0; i < arr1.length; i++) {
            sum += Math.pow(Math.abs(arr1[i] - arr2[i]), 2);
        }

        return sum / arr1.length;
    }

    public static void main(String[] args) {
        System.out.printf("1. %s\n", solution(new int[] {1, 2, 3}, new int[] {4, 5, 6})); // 9
        System.out.printf("1. %s\n", solution(new int[] {10, 20, 10, 2}, new int[] {10, 25, 5, -2})); // 16.5
        System.out.printf("1. %s\n", solution(new int[] {-1, 0}, new int[] {0, -1})); // 1
    }
}
