package Tree;

public class Sum_Root_To_Leaf {
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
        public int sumNumbers(TreeNode root) {
            return solveFun(root, 0);
        }
        public static int solveFun(TreeNode node, int sum) {
            if (node == null)
                return 0;

            if (node.left == null && node.right == null)
                return sum*10 + node.val;

            int left = solveFun(node.left, sum*10 + node.val);
            int right = solveFun(node.right, sum*10 + node.val);

            return left + right;
        }
    }
}
