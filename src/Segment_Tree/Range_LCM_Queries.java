package Segment_Tree;

public class Range_LCM_Queries {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6, 8, 16};
        int n = arr.length;

        long[] segTree = new long[4*n];
        buildSegmentTree(arr, 0, 0, n-1, segTree);

        System.out.println(getLCM(0, 2, 0, 0, n-1, segTree));

        updateValue(3, 8, 0, 0, n-1, segTree);
        arr[3] = 8;

        System.out.println(getLCM(2, 5, 0, 0, n-1, segTree));

    }
    public static void buildSegmentTree(int[] arr, int i, int l, int r, long[] segTree) {
        if (l == r) {
            segTree[i] = arr[l];
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(arr, 2*i + 1, l, mid, segTree);
        buildSegmentTree(arr, 2*i + 2, mid+1, r, segTree);

        segTree[i] = lcmFun(segTree[2*i + 1], segTree[2*i + 2]);
    }
    public static long lcmFun(long a, long b) {
        return (a / gcdFun(a, b)) * b;         // to avoid overflow
    }
    public static long gcdFun(long dividend, long divisor) {
        while (dividend % divisor != 0) {
            long rem = dividend % divisor;
            dividend = divisor;
            divisor = rem;
        }
        return divisor;
    }
    public static long getLCM(int start, int end, int i, int l, int r, long[] segTree) {
        if (end < l || start > r)
            return 1;
        if (l >= start && r <= end)
            return segTree[i];

        int mid = (l + r)/2;
        long left = getLCM(start, end, 2*i + 1, l, mid, segTree);
        long right = getLCM(start, end, 2*i + 2, mid+1, r, segTree);
        return lcmFun(left, right);
    }
    public static void updateValue(int idx, int val, int i, int l, int r, long[] segTree) {
        if (l == r) {
            segTree[i] = val;
            return;
        }

        int mid = (l + r)/2;
        if (idx <= mid)
            updateValue(idx, val, 2*i + 1, l, mid, segTree);
        else
            updateValue(idx, val, 2*i + 2, mid+1, r, segTree);

        segTree[i] = lcmFun(segTree[2*i + 1], segTree[2*i + 2]);
    }
}
