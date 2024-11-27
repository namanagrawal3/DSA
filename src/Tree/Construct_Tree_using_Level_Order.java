package Tree;

import java.util.*;

public class Construct_Tree_using_Level_Order {
    class Node {
        int val;
        Node left;
        Node right;
    }
    Scanner sc = new Scanner(System.in);
    private Node root;
    public Construct_Tree_using_Level_Order() {
        root = createTree();
    }
    private Node createTree() {
        int item = sc.nextInt();
        Node nn = new Node();
        nn.val = item;
        root = nn;

        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node rv = q.poll();
            int c1 = sc.nextInt();
            int c2 = sc.nextInt();

            if (c1 != -1) {
                Node n = new Node();
                n.val = c1;
                rv.left = n;
                q.add(n);
            }
            if (c2 != -1) {
                Node n = new Node();
                n.val = c2;
                rv.right = n;
                q.add(n);
            }
        }

        return root;
    }
    public void preOrderTraverse() {
        preOrder(root);
        System.out.println();
    }
    private void preOrder(Node node) {                             // O(N)
        if (node == null)
            return;

        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        // input : 10 20 30 40 -1 -1 50 -1 -1 60 -1 -1 -1

        Construct_Tree_using_Level_Order bt = new Construct_Tree_using_Level_Order();
        bt.preOrderTraverse();
    }
}
