package Divide_and_Conquerer;

import java.util.Arrays;

public class Partition_in_Array {
    public static void main(String[] args) {

        // Leetcode Problem - 2161
        // if a user gives a particular index instead of last/first index as Pivot
        // then only swap that index with the last/first index and remaining code same

        int[] arr = {5, 7, 2, 3, 8, 1, 4};
//        int[] arr = {1,4,2,3};
//        int[] arr = {4,2,3};

        int n = arr.length;
        int idx2 = partitionFun(arr,0,n-1);                 // Partition-Algorithm

        System.out.println(idx2);
        System.out.println(Arrays.toString(arr));
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
                int temp = arr[i];      // swap(arr[i], arr[j])
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[si];             // swap(pivot, arr[j])
        arr[si] = arr[j];
        arr[j] = temp;

        return j;
    }
}
