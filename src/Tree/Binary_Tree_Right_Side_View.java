package Tree;

import java.util.*;

public class Binary_Tree_Right_Side_View {
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
        static int maxLevel;
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            maxLevel = -1;

            solveFun(root, 0, ans);

            return ans;
        }
        public static void solveFun(TreeNode node, int currLevel, List<Integer> ans) {
            if (node == null)
                return;

            if (currLevel > maxLevel) {
                ans.add(node.val);
                maxLevel = currLevel;
            }

            solveFun(node.right, currLevel + 1, ans);                           // for the left-side view
            solveFun(node.left, currLevel + 1, ans);                            // first left-child call then right-child call
        }
    }
}
