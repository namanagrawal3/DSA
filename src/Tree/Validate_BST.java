package Tree;

public class Validate_BST {
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
            long min = Long.MAX_VALUE;            // see the constraints
            long max = Long.MIN_VALUE;
            boolean isBst = true;
        }
        public boolean isValidBST(TreeNode root) {
            // if inOrder traversal of a tree is sorted, then it is a bst

            return checkFun(root).isBst;
        }
        public BstPair checkFun(TreeNode node) {
            if (node == null)
                return new BstPair();

            BstPair left = checkFun(node.left);
            BstPair right = checkFun(node.right);

            BstPair self = new BstPair();
            self.min = Math.min(left.min, Math.min(right.min, node.val));
            self.max = Math.max(left.max, Math.max(right.max, node.val));
            self.isBst = left.isBst && right.isBst && node.val > left.max && node.val < right.min;

            return self;
        }
    }
}
