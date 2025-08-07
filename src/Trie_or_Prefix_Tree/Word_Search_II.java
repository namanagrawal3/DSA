package Trie_or_Prefix_Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Word_Search_II {
    class Node {
        char ch;
        HashMap<Character, Node> child = new HashMap<>();
        String isTerminal;
    }
    private Node root;
    public Word_Search_II() {
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

        curr.isTerminal = word;             // "isTerminal" stores the entire word
    }

    public void search(char[][] board, int m, int n, int i, int j, Node curr, List<String> ans) {
        if (i < 0 || i >= m || j < 0 || j >= n || !curr.child.containsKey(board[i][j]))
            return;

        char ch = board[i][j];
        curr = curr.child.get(ch);

        if (curr.isTerminal != null) {
            ans.add(curr.isTerminal);
            curr.isTerminal = null;
        }

        board[i][j] = '*';
        search(board, m, n, i + 1, j, curr, ans);
        search(board, m, n, i, j + 1, curr, ans);
        search(board, m, n, i - 1, j, curr, ans);
        search(board, m, n, i, j - 1, curr, ans);
        board[i][j] = ch;
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};

        Word_Search_II tt = new Word_Search_II();
        for (String word: words) {
            tt.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (tt.root.child.containsKey(board[i][j]))
                    tt.search(board, m, n, i, j, tt.root, ans);
            }
        }

        System.out.println(ans);
    }
}
