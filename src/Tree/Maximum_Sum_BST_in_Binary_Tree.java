package Tree;

public class Maximum_Sum_BST_in_Binary_Tree {
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
        class BstPair {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            boolean isBst = true;
            int sum = 0;      // sum of entire current tree
            int ans = 0;
        }
        public int maxSumBST(TreeNode root) {
            return checkFun(root).ans;
        }
        public BstPair checkFun(TreeNode node) {
            if (node == null)
                return new BstPair();

            BstPair left = checkFun(node.left);
            BstPair right = checkFun(node.right);

            BstPair self = new BstPair();
            self.min = Math.min(left.min, Math.min(right.min, node.val));
            self.max = Math.max(left.max, Math.max(right.max, node.val));
            self.sum = left.sum + right.sum + node.val;
            self.isBst = left.isBst && right.isBst && node.val > left.max && node.val < right.min;

            if (self.isBst)
                self.ans = Math.max(self.sum, Math.max(left.ans, right.ans));
            else
                self.ans = Math.max(left.ans, right.ans);

            return self;
        }
    }
}
