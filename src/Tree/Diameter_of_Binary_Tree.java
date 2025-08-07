package Tree;

public class Diameter_of_Binary_Tree {
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
        public int diameterOfBinaryTree(TreeNode root) {                        // O(N^2) approach
            if (root == null)
                return 0;

            int leftDia = diameterOfBinaryTree(root.left);
            int rightDia = diameterOfBinaryTree(root.right);
            int selfDia = height(root.left) + height(root.right) + 2;

            return Math.max(selfDia, Math.max(leftDia, rightDia));
        }
        public static int height(TreeNode node) {
            if (node == null)
                return -1;

            int left = height(node.left);
            int right = height(node.right);

            return Math.max(left, right) + 1;
        }
    }
}
