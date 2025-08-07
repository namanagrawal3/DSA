package Sorting_Algorithm;

import java.util.Arrays;

public class Heap_Sort {
    public static void main(String[] args) {
        int[] arr = {7, -2, 9, 0, 5, 4, 1};
//        int[] arr = {3, 2, 1, 0};
        int n = arr.length;

        heapify(arr, n);                        // converting the array to maxHeap --> O(n)

        for (int i = 0; i < n-1; i++) {         // deleting 'n' times --> n * O(log n)
            deleteFun(arr, n-i);
        }

        System.out.println(Arrays.toString(arr));
    }
    public static void heapify(int[] arr, int n) {
        // Elements at index 'i' (i >= n/2) have no child ,ie, are leaf nodes

        for (int i = n/2 -1; i >= 0; i--) {
            adjustFun(arr, i, n);                  // step-down
        }
    }
    public static void adjustFun(int[] arr, int pi, int size) {
        int lci = 2*pi + 1;
        int rci = 2*pi + 2;
        int maxi = pi;
        // 'maxi' will store the index of the element which is greater among the parent and children

        if (lci < size && arr[lci] > arr[maxi])
            maxi = lci;
        if (rci < size && arr[rci] > arr[maxi])
            maxi = rci;

        if (maxi != pi) {
            swapFun(arr, maxi, pi);
            adjustFun(arr, maxi, size);
        }
    }
    public static void swapFun(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void deleteFun(int[] arr, int size) {
        swapFun(arr, 0, size-1);
        adjustFun(arr, 0, size-1);
    }
}
