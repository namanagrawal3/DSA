package Segment_Tree;

import java.util.Scanner;

public class K_th_One {
    public static void main(String[] args) {
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
                int idx = sc.nextInt();
                arr[idx] = 1 - arr[idx];
                updateValue(idx, 0, 0, n-1, segTree);
            }
            else {
                int k = sc.nextInt();
                int sum = k+1;
                System.out.println(kthOne(sum, 0, 0, n-1, segTree));
            }
        }
    }
    public static void buildSegmentTree(int[] arr, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = arr[l];
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(arr, 2*i + 1, l, mid, segTree);
        buildSegmentTree(arr, 2*i + 2, mid+1, r, segTree);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    public static void updateValue(int idx, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = 1 - segTree[i];
            return;
        }

        int mid = (l + r)/2;
        if (idx <= mid)
            updateValue(idx, 2*i + 1, l, mid, segTree);
        else
            updateValue(idx, 2*i + 2, mid+1, r, segTree);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    public static int kthOne(int sum, int i, int l, int r, int[] segTree) {
        if (l == r) {           // Recursive binary search using tree traversal (like updateValue)
            return l;
        }

        int mid = (l + r)/2;
        if (segTree[2*i + 1] >= sum)
            return kthOne(sum, 2*i + 1, l, mid, segTree);
        else
            return kthOne(sum - segTree[2*i + 1], 2*i + 2, mid+1, r, segTree);
    }
}
