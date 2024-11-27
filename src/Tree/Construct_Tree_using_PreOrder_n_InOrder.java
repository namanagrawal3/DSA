package Tree;

public class Construct_Tree_using_PreOrder_n_InOrder {
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            return createTree(preorder, inorder, 0, n-1, 0, n-1);
        }
        public TreeNode createTree(int[] preOrder, int[] inOrder, int preSi, int preEi, int inSi, int inEi) {
            if (preSi > preEi || inSi > inEi)
                return null;

            TreeNode root = new TreeNode(preOrder[preSi]);
            int idx = searchIdx(inOrder, inSi, inEi, root.val);
            int left = idx - inSi;                              // no. of elements on the left side of root in inOrder

            root.left = createTree(preOrder, inOrder, preSi+1, preSi+left, inSi, idx-1);
            root.right = createTree(preOrder, inOrder, preSi+left+1, preEi, idx+1, inEi);

            return root;
        }
        public int searchIdx(int[] inOrder, int si, int ei, int item) {
            for (int i = si; i <= ei; i++) {
                if (inOrder[i] == item)
                    return i;
            }
            return -1;
        }
    }
}
