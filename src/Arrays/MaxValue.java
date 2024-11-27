package Arrays;

import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(maxValue(arr));
    }
    public static int maxValue(int[] arr) {
        int n = arr.length;
        int max = arr[0];                 // or Integer.MIN_VALUE

        for (int i = 0; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
