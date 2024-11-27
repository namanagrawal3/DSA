package Divide_and_Conquerer;

public class Merge_Sort {
    public static void main(String[] args) {
        int[] arr = {0, 7, 5, 1, 4, 3, -3, 10};

        int[] ans = mergeSort(arr, 0, arr.length-1);

        for (int i = 0; i < ans.length; i++) {                  // original array is not sorted (not inplace)
            System.out.print(ans[i]+" ");
        }
    }
    public static int[] mergeSort(int[] arr, int si, int ei) {
        if (si == ei)
            return new int[] {arr[si]};

        int mid = si + (ei-si)/2;
        int[] left = mergeSort(arr, si, mid);
        int[] right = mergeSort(arr, mid+1, ei);

        return mergeSortedArrays(left, right);
    }
    public static int[] mergeSortedArrays(int[] arr, int[] brr) {
        int n = arr.length;
        int m = brr.length;

        int[] ans = new int[n+m];
        int idx = 0;

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (arr[i] <= brr[j]) {
                ans[idx++] = arr[i];
                i++;
            }
            else {
                ans[idx++] = brr[j];
                j++;
            }
        }
        while (i < n) {
            ans[idx++] = arr[i];
            i++;
        }
        while (j < m) {
            ans[idx++] = brr[j];
            j++;
        }
        
        return ans;
    }
}
