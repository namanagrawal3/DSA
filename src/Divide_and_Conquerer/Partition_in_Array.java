package Divide_and_Conquerer;

public class Partition_in_Array {
    public static void main(String[] args) {

        // Leetcode Problem - 2161
        // if a user gives a particular index instead of last index
        // then only swap that index with the last index and remaining code same

//        int[] arr = {5, 7, 2, 3, 8, 1, 4};
//        int[] arr = {1,4,2,3};
        int[] arr = {4,2,3};
        int n = arr.length;

//        int idx = correctPosition(arr,0,n-1);
//        System.out.println(idx);

        int idx2 = partitionFun(arr,0,n-1);
        System.out.println(idx2);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static int correctPosition(int[] arr, int si, int ei) {
        int item = arr[ei];
        int idx = si;

        for (int i = si; i < ei; i++) {
            if (arr[i] <= item) {
                int temp = arr[idx];            // swap(i,idx)
                arr[idx] = arr[i];
                arr[i] = temp;
                idx++;
            }
        }
        int temp = arr[idx];                   // swap(idx,ei)
        arr[idx] = arr[ei];
        arr[ei] = temp;
        return idx;
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
        int temp = arr[si];          // swap(pivot, arr[j])
        arr[si] = arr[j];
        arr[j] = temp;

        return j;
    }
}
