package Tree;

public class Diameter_of_Binary_Tree_Optimised {
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
        class DiaPair {
            int dt = 0;         // diameter
            int ht = -1;        // height
        }
        public int diameterOfBinaryTree(TreeNode root) {
            return diameter(root).dt;
        }
        public DiaPair diameter(TreeNode node) {                            // O(N)
            if (node == null)
                return new DiaPair();

            DiaPair left = diameter(node.left);
            DiaPair right = diameter(node.right);

            DiaPair root = new DiaPair();
            int self = left.ht + right.ht + 2;
            root.dt = Math.max(self, Math.max(left.dt, right.dt));
            root.ht = Math.max(left.ht, right.ht) + 1;

            return root;
        }
    }
}
