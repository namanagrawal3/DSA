package Tree;

import java.util.Stack;

public class Infix_Expression_Tree {
    static class Node {
        char val;
        Node left;
        Node right;
        public Node(char v) {
            val = v;
        }
        public Node(char v, Node lc, Node rc) {
            val = v;
            left = lc;
            right = rc;
        }
    }
    public static void main(String[] args) {
        String s = "2-3/(5*2)+1";               // infix-notation
        String postFix = postFun(s);            // postfix-notation
        System.out.println(postFix);

        Node root = createTree(postFix);
        postTraverse(root);
    }
    public static String postFun(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int n = s.length();

        int i = 0;
        while (i < n) {
            char ch = s.charAt(i);
            if (ch >= 48 && ch <= 57)    // operand
                ans.append(ch);
            else if (ch == '(')
                st.push(ch);
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    ans.append(st.pop());
                }
                st.pop();
            }
            else {                      // operator
                while (!st.isEmpty() && priority(st.peek()) >= priority(ch)) {
                    ans.append(st.pop());
                }
                st.push(ch);
            }
            i++;
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }
    public static int priority(char ch) {
        if (ch == '^')
            return 3;
        else if (ch == '*' || ch == '/')
            return 2;
        else if (ch == '+' || ch == '-')
            return 1;
        return -1;
    }
    public static Node createTree(String postFix) {
        Stack<Node> st = new Stack<>();
        int n = postFix.length();

        int i = 0;
        while (i < n) {
            char ch = postFix.charAt(i);
            if (ch >= 48 && ch <= 57)           // operand
                st.push(new Node(ch));
            else {                              // operator
                Node second = st.pop();
                Node first = st.pop();
                st.push(new Node(ch, first, second));
            }
            i++;
        }
        return st.peek();
    }
    public static void postTraverse(Node root) {
        if (root == null)
            return;

        postTraverse(root.left);
        postTraverse(root.right);
        System.out.print(root.val);
    }
}
