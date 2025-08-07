package Tree;

public class Largest_BST_Subtree {
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
            int count = 0;
        }
        public int largestBst(TreeNode root) {
            return checkFun(root).count;
        }
        public BstPair checkFun(TreeNode node) {
            if (node == null)
                return new BstPair();

            BstPair left = checkFun(node.left);
            BstPair right = checkFun(node.right);

            BstPair self = new BstPair();
            self.min = Math.min(left.min, Math.min(right.min, node.val));
            self.max = Math.max(left.max, Math.max(right.max, node.val));
            self.isBst = left.isBst && right.isBst && (node.val > left.max && node.val < right.min);

            if (self.isBst)
                self.count = left.count + right.count + 1;
            else
                self.count = Math.max(left.count, right.count);

            return self;
        }
    }
}
