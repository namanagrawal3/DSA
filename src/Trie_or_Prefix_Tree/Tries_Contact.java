package Trie_or_Prefix_Tree;

import java.util.HashMap;

public class Tries_Contact {
    class Node {
        char ch;
        HashMap<Character, Node> child = new HashMap<>();
        boolean isTerminal = false;
        int count = 0;
    }
    private Node root;
    public Tries_Contact() {
        root = new Node();
        root.ch = '*';
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.child.containsKey(ch)) {
                curr = curr.child.get(ch);
                curr.count++;
            }
            else {
                Node nn = new Node();
                nn.ch = ch;
                nn.count = 1;
                curr.child.put(ch, nn);
                curr = nn;
            }
        }

        curr.isTerminal = true;             // marking as Terminal Node (end of the word)
    }

    public int findPartial(String part) {
        Node curr = root;
        for (int i = 0; i < part.length(); i++) {
            char ch = part.charAt(i);
            if (curr.child.containsKey(ch))
                curr = curr.child.get(ch);
            else
                return 0;
        }

        return curr.count;
    }


    public static void main(String[] args) {
        String[] query = {"add hack", "add hackerrank", "find hac", "find hak"};

        Tries_Contact tt = new Tries_Contact();
        for (String q : query) {
            if (q.charAt(0) == 'a')
                tt.insert(q.substring(4));
            else
                System.out.println(tt.findPartial(q.substring(5)));
        }
    }
}
