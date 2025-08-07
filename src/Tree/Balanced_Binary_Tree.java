package Tree;

public class Balanced_Binary_Tree {
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
        public boolean isBalanced(TreeNode root) {                          // O(N^2) approach
            if (root == null)
                return true;

            boolean left = isBalanced(root.left);
            if (left == false)
                return false;

            boolean right = isBalanced(root.right);
            if (right == false)
                return false;

            int self = Math.abs(height(root.left) - height(root.right));
            return self <= 1;                                              // or, return left && right && self
        }
        public int height(TreeNode node) {
            if (node == null)
                return -1;

            int left = height(node.left);
            int right = height(node.right);

            return Math.max(left, right) + 1;
        }
    }
}
