package Tree;

public class Balanced_Binary_Tree_Optimised {
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
        class Pair {
            boolean isBalance = true;
            int ht = -1;                             // Height
        }
        public boolean isBalanced(TreeNode root) {                              // O(N) approach
            return checkFun(root).isBalance;
        }
        public Pair checkFun(TreeNode node) {
            if (node == null)
                return new Pair();

            Pair left = checkFun(node.left);
            Pair right = checkFun(node.right);

            Pair self = new Pair();
            self.ht = Math.max(left.ht, right.ht) + 1;
            self.isBalance = left.isBalance && right.isBalance && (Math.abs(left.ht - right.ht) <= 1);

            return self;
        }
    }
}
