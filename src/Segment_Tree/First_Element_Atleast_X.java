package Segment_Tree;

import java.util.*;
public class First_Element_Atleast_X {
    public static void main(String[] args) {
//        5 7
//        1 3 2 4 6
//        2 2
//        2 5
//        1 2 5
//        2 4
//        2 8
//        1 3 7
//        2 6

        // We have to find the minimum index (means leftmost index) at which element is greater than x
        // (variation of range min/max index using binary search)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] segTree = new int[4*n];
        buildSegmentTree(arr, 0, 0, n-1, segTree);

        while (m-- > 0) {
            int type = sc.nextInt();
            if (type == 1) {
                int i = sc.nextInt();
                int v = sc.nextInt();
                arr[i] = v;
                updateValue(i, v, arr,0, 0, n-1, segTree);
            }
            else {
                int x = sc.nextInt();
                int si = 0;
                int ei = n-1;
                int ans = n;

                while (si <= ei) {          // Leftmost i (max-index) such that arr[i] >= x
                    int mid = si + (ei-si)/2;
                    int idx = maxIdxRange(si, mid, arr, 0, 0, n-1, segTree);
                    if (arr[idx] >= x) {
                        ans = Math.min(ans, idx);
                        ei = mid - 1;
                    }
                    else
                        si = mid + 1;
                }

                System.out.println((ans == n) ? -1 : ans);
            }
        }
    }
    public static void buildSegmentTree(int[] arr, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = l;
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(arr, 2*i + 1, l, mid, segTree);
        buildSegmentTree(arr, 2*i + 2, mid+1, r, segTree);

        if (arr[segTree[2*i + 1]] > arr[segTree[2*i + 2]])
            segTree[i] = segTree[2*i + 1];
        else
            segTree[i] = segTree[2*i + 2];
    }
    public static void updateValue(int idx, int val, int[] arr, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = l;
            return;
        }

        int mid = (l + r)/2;
        if (idx <= mid)
            updateValue(idx, val, arr, 2*i + 1, l, mid, segTree);
        else
            updateValue(idx, val, arr, 2*i + 2, mid+1, r, segTree);

        if (arr[segTree[2*i + 1]] > arr[segTree[2*i + 2]])
            segTree[i] = segTree[2*i + 1];
        else
            segTree[i] = segTree[2*i + 2];
    }
    public static int maxIdxRange(int start, int end, int[] arr, int i, int l, int r, int[] segTree) {
        if (end < l || start > r)
            return -1;
        if (l >= start && r <= end)
            return segTree[i];

        int mid = (l + r)/2;
        int leftIdx = maxIdxRange(start, end, arr, 2*i + 1, l, mid, segTree);
        int rightIdx = maxIdxRange(start, end, arr, 2*i + 2, mid+1, r, segTree);

        if (leftIdx == -1)
            return rightIdx;
        if (rightIdx == -1)
            return leftIdx;

        return (arr[leftIdx] > arr[rightIdx]) ? leftIdx : rightIdx;
    }
}
