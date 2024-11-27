package Tree;

public class Flip_Equivalent_Binary_Trees {
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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {                      // check if trees are "Isomorphic"
        if (root1 == null && root2 == null)
            return true;

        if (root1 == null || root2 == null)
            return false;

        if (root1.val != root2.val)
            return false;

        // mirror image
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        // same tree
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);

        return flip || noFlip;
    }
}
