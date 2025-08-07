package Segment_Tree;

public class Range_Longest_Correct_Bracket_Subsequence_Queries {
    static class Pair {
        int pairs = 0;          // matched pairs
        int unused_open = 0;    // unused open brackets
        int unused_close = 0;   // unused closed brackets
    }
    public static void main(String[] args) {
        String s = "())(())(())(" ;
        int[][] queries = {{3,6}, {0,11}};

        int n = s.length();
        Pair[] segTree = new Pair[4*n];
        buildSegmentTree(s, 0, 0, n-1, segTree);

        for (int[] q: queries) {
            System.out.println(lenFun(q[0], q[1], 0, 0, n-1, segTree).pairs * 2);
        }
    }
    public static void buildSegmentTree(String s, int i, int l, int r, Pair[] segTree) {
        if (l == r) {
            segTree[i] = new Pair();
            if (s.charAt(l) == '(')
                segTree[i].unused_open = 1;
            else
                segTree[i].unused_close = 1;
            return;
        }

        int mid = (l + r)/2;
        buildSegmentTree(s, 2*i + 1, l, mid, segTree);
        buildSegmentTree(s, 2*i + 2, mid+1, r, segTree);

        segTree[i] = mergeFun(segTree[2*i + 1], segTree[2*i + 2]);
    }
    public static Pair mergeFun(Pair left, Pair right) {
        Pair parent = new Pair();
        int min = Math.min(left.unused_open, right.unused_close);

        parent.pairs = left.pairs + right.pairs + min;
        parent.unused_open = left.unused_open + right.unused_open - min;
        parent.unused_close = left.unused_close + right.unused_close - min;
        return parent;
    }
    public static Pair lenFun(int start, int end, int i, int l, int r, Pair[] segTree) {
        if (end < l || start > r)
            return new Pair();
        if (l >= start && r <= end)
            return segTree[i];

        int mid = (l + r)/2;
        Pair left = lenFun(start, end, 2*i + 1, l, mid, segTree);
        Pair right = lenFun(start, end, 2*i + 2, mid+1, r, segTree);

        return mergeFun(left, right);
    }
}
