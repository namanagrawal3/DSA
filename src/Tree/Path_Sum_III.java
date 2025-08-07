package Tree;

public class Path_Sum_III {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            return pathFun(root, targetSum);                        // O(n^2) Approach

            // O(n) Approach --> PrefixSum using HashMap (similar to count subarrays sum k)
        }
        public int pathFun(TreeNode node, long targetSum) {
            if (node == null)
                return 0;

            int c = CountPath(node, targetSum);
            int l = pathFun(node.left, targetSum);
            int r = pathFun(node.right, targetSum);

            return l + r + c;
        }
        public int CountPath(TreeNode node, long targetSum) {
            if (node == null)
                return 0;

            int count = 0;
            if (node.val - targetSum == 0)
                count++;

            int left = CountPath(node.left, targetSum - node.val);
            int right = CountPath(node.right, targetSum - node.val);

            return left + right + count;
        }
    }
}
