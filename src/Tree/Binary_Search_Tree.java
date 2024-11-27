package Tree;

public class Binary_Search_Tree {
    class Node {
        int val;
        Node left;
        Node right;
    }
    private Node root;
    public Binary_Search_Tree(int[] arr) {
        root = createTree(arr, 0, arr.length-1);
    }
    private Node createTree(int[] inOrder, int si, int ei) {
        if (si > ei)
            return null;

        int mid = si + (ei - si)/2;

        Node nn = new Node();
        nn.val = inOrder[mid];

        nn.left = createTree(inOrder, si,mid-1);
        nn.right = createTree(inOrder,mid+1, ei);

        return nn;
    }
    public int max() {
        return maxFun(root);
    }
    private int maxFun(Node node) {                              // similarly, for min value always go to the left side
        if (node == null)
            return Integer.MIN_VALUE;

        return Math.max(maxFun(node.right), node.val);
    }
    public boolean search(int item) {
        return searchFun(root, item);
    }
    private boolean searchFun(Node node, int item) {
        if (node == null)
            return false;

        if (node.val == item)
            return true;
        else if (node.val < item)
            return searchFun(node.right, item);
        else
            return searchFun(node.left, item);
    }
}
