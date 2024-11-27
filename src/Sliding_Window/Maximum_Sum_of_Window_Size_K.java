package Sliding_Window;

public class Maximum_Sum_of_Window_Size_K {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 1, 5, 6, 8, 2, 6, 8, 9, 2, 1, 3};
        int k = 3;

        int sum = 0;
        int n = arr.length;

        int si = 0, ei = 0;
        for (; ei < k; ei++) {
            sum += arr[ei];
        }
        int maxSum = sum;

        while (ei < n) {
            sum += arr[ei];                 // window is growing

            sum -= arr[si];                 // window is shrinking
            si++;

            maxSum = Math.max(maxSum, sum);
            ei++;
        }

        System.out.println(maxSum);
    }
}
