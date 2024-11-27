package Sorting_Algorithm;

public class Counting_Sort {
    public static void main(String[] args) {
        // constraint:   -50 <= arr[i] <= 50

        int[] arr = {50, 41, -31, -2, 19, 0, -31, -49, 25, 50};
        int n = arr.length;

        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        int[] fre = new int[max+1+50];                   // stores the frequency of each element

        for (int i = 0; i < n; i++) {
            fre[arr[i] + 50]++;
        }

        for (int i = 0; i < fre.length; i++) {
            if (fre[i] > 0) {
                int k = fre[i];
                while (k-- > 0) {
                    System.out.print(i-50 + " ");
                }
            }
        }
    }
}
