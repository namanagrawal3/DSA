package Sorting_Algorithm;

public class Insertion_Sort {
    public static void main(String[] args) {

        int[] arr = {-3, -10, 12, -3, 7, 0};
        int n = arr.length;

        insertionSort(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void insertionSort(int[] arr){
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            insertLastElement(arr, i);
        }
    }
    public static void insertLastElement(int[] arr, int i) {
        int item = arr[i];
        int j = i-1;

        while (j >= 0 && arr[j] > item) {
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = item;
    }
}
