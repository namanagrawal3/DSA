package Segment_Tree;

public class Count_Inversions {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};

        System.out.println(countInversions(arr));
    }
    public static int countInversions(int[] arr) {
        int n = arr.length;
        return mergeSort(arr, 0, n-1);
    }
    public static int mergeSort(int[] arr, int l, int r) {
        int cnt = 0;
        if (l == r)
            return cnt;

        int mid = (l + r)/2;
        cnt += mergeSort(arr, l, mid);
        cnt += mergeSort(arr, mid+1, r);
        cnt += merge(arr, l, mid, r);
        return cnt;
    }
    public static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        int i = 0, cnt = 0;
        int left = l;
        int right = mid+1;

        while (left <= mid && right <= r) {
            if (arr[left] <= arr[right]) {
                temp[i++] = arr[left];
                left++;
            }
            else {
                temp[i++] = arr[right];
                cnt += mid - left + 1;
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

        return cnt;
    }
}
