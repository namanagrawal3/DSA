package Tree;
import java.util.*;

public class Zigzag_Level_Order_Traversal {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();

            if (root == null)
                return ans;

            q.add(root);
            int level = 0;

            while(!q.isEmpty()) {
                int n = q.size();
                List<Integer> l = new ArrayList<>();

                for (int i = 0; i < n; i++) {
                    TreeNode rv = q.poll();

                    if (rv.left != null)
                        q.add(rv.left);

                    if (rv.right != null)
                        q.add(rv.right);

                    l.add(rv.val);
                }

                if (level % 2 != 0)
                    reverseFun(l);

                level++;
                ans.add(l);
            }
            return ans;
        }
        public static void reverseFun(List<Integer> l) {
            int left = 0, right = l.size()-1;
            while (left < right) {
                int temp = l.get(left);
                l.set(left, l.get(right));
                l.set(right, temp);
                left++;
                right--;
            }
        }
    }
}
