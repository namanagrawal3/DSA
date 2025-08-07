package Trie_or_Prefix_Tree;

import java.util.HashMap;

public class Longest_Common_Prefix {
    class Node {
        char ch;
        HashMap<Character, Node> child = new HashMap<>();
        boolean isTerminal = false;
    }
    private Node root;
    public Longest_Common_Prefix() {
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

    public String longestCommonPrefix() {
        StringBuilder prefix = new StringBuilder();
        Node curr = root;
        while (!curr.isTerminal) {
            if (curr.child.size() > 1)
                return prefix.toString();

            for (char ch : curr.child.keySet()) {
                curr = curr.child.get(ch);
                prefix.append(ch);
            }
        }

        return prefix.toString();
    }

    public static void main(String[] args) {
        String words[] = {"geeksforgeeks", "geeks", "geek", "geezer"};

        Longest_Common_Prefix tt = new Longest_Common_Prefix();
        for (String word: words) {
            tt.insert(word);
        }

        System.out.println(tt.longestCommonPrefix());
    }
}
