package Segment_Tree;

import java.util.Scanner;
public class Number_of_Minimums_on_a_Segment {
    public static void main(String[] args) {
//        5 5
//        3 4 3 5 2
//        2 0 3
//        1 1 2
//        2 0 3
//        1 0 2
//        2 0 5
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] segTree = new int[4*n][2];
        buildSegmentTree(arr, 0, 0, n-1, segTree);

        while (m-- > 0) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (t == 1) {
                arr[a] = b;
                updateValue(a, b, 0, 0, n-1, segTree);
            }
            else {
                int[] ans = countMinRange(a, b - 1, 0, 0, n - 1, segTree);
                System.out.println(ans[0]+" "+ans[1]);
            }
        }
    }
    public static void buildSegmentTree(int[] arr, int i, int l, int r, int[][] segTree) {
        if (l == r) {
            segTree[i][0] = arr[l];
            segTree[i][1] = 1;
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(arr, 2*i + 1, l, mid, segTree);
        buildSegmentTree(arr, 2*i + 2, mid+1, r, segTree);

        if (segTree[2*i + 1][0] < segTree[2*i + 2][0]) {
            segTree[i][0] = segTree[2*i + 1][0];
            segTree[i][1] = segTree[2*i + 1][1];
        }
        else if (segTree[2*i + 2][0] < segTree[2*i + 1][0]) {
            segTree[i][0] = segTree[2*i + 2][0];
            segTree[i][1] = segTree[2*i + 2][1];
        }
        else {
            segTree[i][0] = segTree[2*i + 1][0];
            segTree[i][1] = segTree[2*i + 1][1] + segTree[2*i + 2][1];
        }
    }
    public static void updateValue(int idx, int value, int i, int l, int r, int[][] segTree) {
        if (l == r) {
            segTree[i][0] = value;
            return;
        }

        int mid = (l + r)/2;
        if (idx <= mid)
            updateValue(idx, value, 2*i + 1, l, mid, segTree);
        else
            updateValue(idx, value, 2*i + 2, mid+1, r, segTree);

        if (segTree[2*i + 1][0] < segTree[2*i + 2][0]) {
            segTree[i][0] = segTree[2*i + 1][0];
            segTree[i][1] = segTree[2*i + 1][1];
        }
        else if (segTree[2*i + 2][0] < segTree[2*i + 1][0]) {
            segTree[i][0] = segTree[2*i + 2][0];
            segTree[i][1] = segTree[2*i + 2][1];
        }
        else {
            segTree[i][0] = segTree[2*i + 1][0];
            segTree[i][1] = segTree[2*i + 1][1] + segTree[2*i + 2][1];
        }
    }
    public static int[] countMinRange(int start, int end, int i, int l, int r, int[][] segTree) {
        if (l > end || r < start)
            return new int[]{Integer.MAX_VALUE, 0};
        if (l >= start && r <= end)
            return segTree[i];

        int mid = (l + r)/2;
        int[] left = countMinRange(start, end, 2*i + 1, l, mid, segTree);
        int[] right = countMinRange(start, end, 2*i + 2, mid+1, r, segTree);

        int[] ans = new int[2];
        if (left[0] < right[0]) {
            ans[0] = left[0];
            ans[1] = left[1];
        }
        else if (left[0] > right[0]) {
            ans[0] = right[0];
            ans[1] = right[1];
        }
        else {
            ans[0] = left[0];
            ans[1] = left[1] + right[1];
        }
        return ans;
    }
}
