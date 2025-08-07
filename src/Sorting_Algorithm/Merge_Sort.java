package Sorting_Algorithm;

import java.util.*;
public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = {3, 0, 5, -1, 6, 2};
        int n = arr.length;

        mergeSort(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r)
            return;

        int mid = (l + r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
    public static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        int i = 0;
        int left = l;
        int right = mid+1;

        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[i++] = arr[left];
                left++;
            }
            else {
                temp[i++] = arr[right];
                right++;
            }
        }

        while (left <= mid) {
            temp[i++] = arr[left];
            left++;
        }

        while (right <= r) {
            temp[i++] = arr[right];
            right++;
        }

        for (int j = 0; j < temp.length; j++) {
            arr[l+j] = temp[j];
        }
    }
}
