package Divide_and_Conquerer;

import java.util.Arrays;

public class Quick_Sort {
    public static void main(String[] args) {
        int[] arr = {5, 7, 2, 3, 0, -3, 1, 4};

        int n = arr.length;
        quickSort(arr,0,n-1);

        System.out.println(Arrays.toString(arr));                       // Original array is sorted itself (in-place)
    }
    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei)
            return;

        int idx = partitionFun(arr, si, ei);

        quickSort(arr, si, idx-1);
        quickSort(arr, idx+1, ei);
    }
    public static int partitionFun(int[] arr, int si, int ei) {
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
                int temp = arr[i];   // swap(arr[i], arr[j])
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[si];          // swap(pivot, arr[j])
        arr[si] = arr[j];
        arr[j] = temp;

        return j;
    }
}
