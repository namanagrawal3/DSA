package Heap;

import java.util.Arrays;

public class MaxHeap_Heapify_Method {
    public static void main(String[] args) {
        int[] arr = {7, 1, 2, 3, 4, 5, 6};
        int n = arr.length;

        heapify(arr, n);
        System.out.println(Arrays.toString(arr));
    }
    public static void heapify(int[] arr, int n) {
        // Elements at index 'i' (i >= n/2) have no child ,ie, are leaf nodes

        for (int i = n/2 -1; i >= 0; i--) {
            adjustFun(arr, i);                  // step-down
        }
    }
    public static void adjustFun(int[] arr, int pi) {
        int lci = 2*pi + 1;
        int rci = 2*pi + 2;
        int maxi = pi;
        // 'maxi' will store the index of the element which is greater among the parent and children

        if (lci < arr.length && arr[lci] > arr[maxi])
            maxi = lci;
        if (rci < arr.length && arr[rci] > arr[maxi])
            maxi = rci;

        if (maxi != pi) {
            swapFun(arr, maxi, pi);
            adjustFun(arr, maxi);
        }
    }
    public static void swapFun(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
