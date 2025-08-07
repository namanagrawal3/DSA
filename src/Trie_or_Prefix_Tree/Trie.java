package Trie_or_Prefix_Tree;

import java.util.HashMap;

public class Trie {
    class Node {
        char ch;
        HashMap<Character, Node> child = new HashMap<>();
        boolean isTerminal = false;
    }
    private Node root;
    public Trie() {
        root = new Node();
        root.ch = '*';
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.child.containsKey(ch)) {
                curr = curr.child.get(ch);
            }
            else {
                Node nn = new Node();
                nn.ch = ch;
                curr.child.put(ch, nn);
                curr = nn;
            }
        }

        curr.isTerminal = true;             // marking as Terminal Node (end of the word)
    }
    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.child.containsKey(ch))
                curr = curr.child.get(ch);
            else
                return false;
        }

        return curr.isTerminal;
    }
    public boolean startWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.child.containsKey(ch))
                curr = curr.child.get(ch);
            else
                return false;
        }

        return true;
    }
}
