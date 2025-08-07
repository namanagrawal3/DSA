package Recursion_Backtracking;

public class Word_Search {
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean ans = checkword(board, m, n, i, j, word, 0);
                    if (ans) {
                        System.out.println(true);
                        return;
                    }
                }
            }
        }

        System.out.println(false);
    }
    public static boolean checkword(char[][] board, int m, int n, int cr, int cc, String word, int idx) {
        if (idx == word.length())
            return true;
        if (cr < 0 || cr >= m || cc < 0 || cc >= n || board[cr][cc] != word.charAt(idx))
            return false;

        board[cr][cc] = '*';                                // Marking as visited

        for(int i = 0; i < 4; i++) {
            boolean ans = checkword(board, m, n,cr+dir[i][0],cc+dir[i][1], word,idx+1);
            if (ans)
                return true;
        }

        board[cr][cc] = word.charAt(idx);                   // Backtrack --> undo the changes
        return false;
    }
}
