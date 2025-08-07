package Segment_Tree;

public class Range_Sum_Query_Mutable {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        int n = nums.length;

        int[] segTree = new int[4*n];
        buildSegmentTree(nums, 0, 0, n-1, segTree);

        System.out.println(sumRange(0, 3, 0, 0, n-1, segTree));
        updateValue(0, 5, 0, 0, n-1, segTree);
        System.out.println(sumRange(0, 3, 0, 0, n-1, segTree));
    }
    public static void buildSegmentTree(int[] nums, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = nums[l];
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(nums, 2*i + 1, l, mid, segTree);
        buildSegmentTree(nums, 2*i + 2, mid+1, r, segTree);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
    public static int sumRange(int start, int end, int i, int l, int r, int[] segTree) {
        // Out of bound
        if (l > end || r < start)
            return 0;

        // [l,r] is completely inside [start, end]
        if (l >= start && r <= end)
            return segTree[i];

        // Overlapping
        int mid = (l + r)/2;
        int left = sumRange(start, end, 2*i + 1, l, mid, segTree);
        int right = sumRange(start, end, 2*i + 2, mid+1, r, segTree);
        return left + right;
    }
    public static void updateValue(int idx, int value, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = value;
            return;
        }

        int mid = (l + r)/2;
        if (idx <= mid)
            updateValue(idx, value, 2*i + 1, l, mid, segTree);
        else
            updateValue(idx, value, 2*i + 2, mid+1, r, segTree);

        segTree[i] = segTree[2*i + 1] + segTree[2*i + 2];
    }
}
