package Segment_Tree;

import java.util.*;

public class Segment_with_the_Maximum_Sum {
    static class Pair {
        long maxSum;
        long sum;
        long pref;
        long suff;
        public Pair(){}
        public Pair(long ms, long s, long pf, long sf) {
            maxSum = ms;
            sum = s;
            pref = pf;
            suff = sf;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Pair[] segTree = new Pair[4*n];
        buildSegmentTree(arr, 0, 0, n-1, segTree);

        System.out.println(Math.max(segTree[0].maxSum, 0));

        while (m-- > 0) {
            int i = sc.nextInt();
            int v = sc.nextInt();
            arr[i] = v;
            updateValue(i, v, 0, 0, n-1, segTree);
            System.out.println(Math.max(segTree[0].maxSum, 0));
        }
    }
    public static void buildSegmentTree(int[] arr, int i, int l, int r, Pair[] segTree) {
        if (l == r) {
            segTree[i] = new Pair(arr[l], arr[l], arr[l], arr[l]);
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(arr, 2*i + 1, l, mid, segTree);
        buildSegmentTree(arr, 2*i + 2, mid+1, r, segTree);

        segTree[i] = new Pair();
        Pair left = segTree[2*i + 1];
        Pair right = segTree[2*i + 2];
        segTree[i].sum = left.sum + right.sum;
        segTree[i].pref = Math.max(left.pref, left.sum + right.pref);
        segTree[i].suff = Math.max(right.suff, right.sum + left.suff);
        segTree[i].maxSum = Math.max(left.suff + right.pref, Math.max(left.maxSum, right.maxSum));
    }
    public static void updateValue(int idx, int val, int i, int l, int r, Pair[] segTree) {
        if (l == r) {
            segTree[i] = new Pair(val, val, val, val);
            return;
        }

        int mid = (l + r)/2;
        if (idx <= mid)
            updateValue(idx, val, 2*i + 1, l, mid, segTree);
        else
            updateValue(idx, val, 2*i + 2, mid+1, r, segTree);

        Pair left = segTree[2*i + 1];
        Pair right = segTree[2*i + 2];
        segTree[i].sum = left.sum + right.sum;
        segTree[i].pref = Math.max(left.pref, left.sum + right.pref);
        segTree[i].suff = Math.max(right.suff, right.sum + left.suff);
        segTree[i].maxSum = Math.max(left.suff + right.pref, Math.max(left.maxSum, right.maxSum));
    }
}
