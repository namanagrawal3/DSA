package Segment_Tree;

public class Fruits_Into_Baskets {
    public static void main(String[] args) {
        int[] fruits = {4,2,5};
        int[] baskets = {3,5,4};

        int n = fruits.length;
        int[] segTree = new int[4*n];
        buildSegTree(baskets, 0, 0, n-1, segTree);

        int cnt = 0;
        for (int fruit: fruits) {
            if (!checkMax(fruit, 0, 0, n-1, segTree))
                cnt++;
        }

        System.out.println(cnt);
    }
    public static void buildSegTree(int[] baskets, int i, int l, int r, int[] segTree) {
        if (l == r) {
            segTree[i] = baskets[l];
            return;
        }

        int mid = (l + r)/2;
        buildSegTree(baskets, 2*i + 1, l, mid, segTree);
        buildSegTree(baskets, 2*i + 2, mid+1, r, segTree);

        segTree[i] = Math.max(segTree[2*i + 1], segTree[2*i + 2]);
    }
    public static boolean checkMax(int fruit, int i, int l, int r, int[] segTree) {
        if (segTree[i] < fruit)
            return false;

        if (l == r) {
            segTree[i] = -1;
            return true;
        }

        int mid = (l + r)/2;
        if (segTree[2*i + 1] >= fruit)
            checkMax(fruit, 2*i + 1, l, mid, segTree);
        else
            checkMax(fruit, 2*i + 2, mid+1, r, segTree);

        segTree[i] = Math.max(segTree[2*i + 1], segTree[2*i + 2]);
        return true;
    }
}
