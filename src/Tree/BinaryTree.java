package Tree;

import java.util.*;
public class BinaryTree {
    public class Node {
        int val;
        Node left;
        Node right;
    }
    private Node root;
    Scanner sc = new Scanner(System.in);
    public BinaryTree() {
        root = createTree();
    }
    private Node createTree() {
        int item = sc.nextInt();
        Node nn = new Node();
        nn.val = item;

        boolean hasLeftChild = sc.nextBoolean();
        if (hasLeftChild)
            nn.left = createTree();

        boolean hasRightChild = sc.nextBoolean();
        if (hasRightChild)
            nn.right = createTree();

        return nn;
    }
    public void display() {
        displayEachNode(root);
    }
    private void displayEachNode(Node node) {                    // O(N)
        if (node == null)
            return;

        String s = "";
        s = "<--" + node.val + "-->";

        if (node.left != null)
            s = node.left.val + s;
        else
            s = "." + s;

        if (node.right != null)
            s = s + node.right.val;
        else
            s = s + ".";

        System.out.println(s);

        displayEachNode(node.left);
        displayEachNode(node.right);
    }
    public boolean find(int item) {
        return findNode(root, item);
    }
    private boolean findNode(Node node, int item) {               // O(N)
        if (node == null)
            return false;

        if (node.val == item)
            return true;

        boolean left = findNode(node.left, item);
        if (left)
            return true;
                                                                  // or, at the end return left || right
        boolean right = findNode(node.right, item);
        if (right)
            return true;

        return false;
    }
    public int findMax() {
        return findMaxEle(root);
    }
    private int findMaxEle(Node node) {                            // O(N)
        if (node == null)
            return Integer.MIN_VALUE;

        int left = findMaxEle(node.left);
        int right = findMaxEle(node.right);

        return Math.max(node.val, Math.max(left, right));
    }
    public int heightOfTree() {
        return height(root);
    }
    private int height(Node node) {                                // O(N)
        if (node == null)
            return -1;

        int left = height(node.left);
        int right = height(node.right);

        return Math.max(left, right) + 1;
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
    public void postOrderTraverse() {
        postOrder(root);
        System.out.println();
    }
    private void postOrder(Node node) {                            // O(N)
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val + " ");
    }
    public void inOrderTraverse() {
        inOrder(root);
        System.out.println();
    }
    private void inOrder(Node node) {                               // O(N)
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.val + " ");
        inOrder(node.right);
    }
    public void levelOrderTraverse() {                               // O(N)
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node rv = q.poll();             // removes first
            System.out.print(rv.val + " ");

            if (rv.left != null)
                q.add(rv.left);

            if (rv.right != null)
                q.add(rv.right);
        }
        System.out.println();
    }
}
