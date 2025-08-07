package Segment_Tree;

import java.security.PublicKey;

public class Range_Min_Max_Queries {
    static class Pair {
        int min;
        int max;
        public Pair() {}
        public Pair(int mn, int mx) {
            min = mn;
            max = mx;
        }
        @Override
        public String toString() {
            return min + " " + max;
        }
    }
    public static void main(String[] args) {
        int[] arr = {11, 3, 7, 5, 9, 1};
        int n = arr.length;

        Pair[] segTree = new Pair[4*n];
        buildSegmentTree(arr, 0, 0, n-1, segTree);

        System.out.println(getMinMax(0, 2, 0, 0, n-1, segTree));
        System.out.println(getMinMax(2, 5, 0, 0, n-1, segTree));

        updateValue(3, 17, 0, 0, n-1, segTree);

        System.out.println(getMinMax(0, 5, 0, 0, n-1, segTree));
    }
    public static void buildSegmentTree(int[] arr, int i, int l, int r, Pair[] segTree) {
        if (l == r) {
            segTree[i] = new Pair(arr[l], arr[l]);
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(arr, 2*i + 1, l, mid, segTree);
        buildSegmentTree(arr, 2*i + 2, mid+1, r, segTree);

        segTree[i] = new Pair();
        segTree[i].min = Math.min(segTree[2*i + 1].min, segTree[2*i + 2].min);
        segTree[i].max = Math.max(segTree[2*i + 1].max, segTree[2*i + 2].max);
    }
    public static Pair getMinMax(int start, int end, int i, int l, int r, Pair[] segTree) {
        // Out-of-bound
        if (end < l || start > r)
            return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);

        // [l,r] lies in [start, end]
        if (l >= start && r <= end)
            return segTree[i];

        // Overlapping
        int mid = (l + r)/2;
        Pair left = getMinMax(start, end, 2*i + 1, l, mid, segTree);
        Pair right = getMinMax(start, end, 2*i + 2, mid+1, r, segTree);

        Pair rv = new Pair();
        rv.min = Math.min(left.min, right.min);
        rv.max = Math.max(left.max, right.max);
        return rv;
    }
    public static void updateValue(int idx, int val, int i, int l, int r, Pair[] segTree) {
        if (l == r) {
            segTree[i].min = val;
            segTree[i].max = val;
            return;
        }

        int mid = (l + r)/2;
        if (idx <= mid)
            updateValue(idx, val, 2*i + 1, l, mid, segTree);
        else
            updateValue(idx, val, 2*i + 2, mid+1, r, segTree);

        segTree[i].min = Math.min(segTree[2*i + 1].min, segTree[2*i + 2].min);
        segTree[i].max = Math.max(segTree[2*i + 1].max, segTree[2*i + 2].max);
    }
}
