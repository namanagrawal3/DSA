package Tree;

public class Delete_Node_in_a_BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null)
                return null;

            if (root.val > key)
                root.left = deleteNode(root.left, key);
            else if (root.val < key)
                root.right = deleteNode(root.right, key);
            else {
                                         // for 0 or 1 child
                if (root.left == null)
                    return root.right;
                else if (root.right == null)
                    return root.left;
                else {                  // for 2 child
                    int max = maxFun(root.left);                  // max value from left-subtree
                    root.val = max;                               // similarly, we can also replace it with the min value from right-subtree
                    root.left = deleteNode(root.left, max);
                }
            }
            return root;
        }
        public static int maxFun(TreeNode root) {
            if (root == null)
                return Integer.MIN_VALUE;

            int rightMax = maxFun(root.right);

            return Math.max(root.val, rightMax);
        }
    }
}
