package Divide_and_Conquerer;

import java.util.Arrays;
import java.util.Random;

public class Randomised_Quick_Sort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 0, -3, 1, 4};

        int n = arr.length;
        randomQuickSort(arr, 0, n-1);

        System.out.println(Arrays.toString(arr));
    }
    public static void randomQuickSort(int[] arr, int si, int ei) {
        if (si >= ei)
            return;

        int idx = randomPartition(arr, si, ei);

        randomQuickSort(arr, si, idx-1);
        randomQuickSort(arr, idx+1, ei);
    }
    public static int randomPartition(int[] arr, int si, int ei) {
        Random rn = new Random();
        int idx = rn.nextInt(ei-si+1) + si;

        int temp = arr[si];           // swap(arr[si], arr[idx])
        arr[si] = arr[idx];
        arr[idx] = temp;

        int i = si, j = ei;
        int pivot = arr[si];

        while (i <= j) {
            while (i <= ei && arr[i] <= pivot) {
                i++;
            }
            while (j >= si && arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int t = arr[i];      // swap(arr[i], arr[j])
                arr[i] = arr[j];
                arr[j] = t;
            }
        }

        temp = arr[si];              // swap(pivot, arr[j])
        arr[si] = arr[j];
        arr[j] = temp;

        return j;
    }
}
