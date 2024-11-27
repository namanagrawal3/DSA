package Sorting_Algorithm;

public class Selection_Sort {
    public static void main(String[] args) {

        int[] arr = {4, -10, 12, -3, 7, 0};
        int n = arr.length;

        selectionSort(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_index = minIdx(arr, i);

            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
    public static int minIdx(int[] arr, int idx) {
        int n = arr.length;
        int min = idx;

        for (int i = idx+1; i < n; i++) {
            if (arr[i] < arr[min])
                min = i;
        }
        return min;
    }
}
