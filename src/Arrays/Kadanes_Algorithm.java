package Arrays;

import java.util.Scanner;

public class Kadanes_Algorithm {
    public static void main(String[] args) {

        // Leetcode -> "Maximum Subarray"

        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;

        System.out.println(maximumSumSubArray(arr));
        System.out.println(kadaneAlgo(arr));

    }

    public static int maximumSumSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int kadaneAlgo(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            maxSum = Math.max(maxSum, sum);

            if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}
