package Recursion;

public class Word_Search {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j] == word.charAt(0)){
                    boolean ans = checkword(board,i,j,word,0);
                    if(ans){
                        System.out.println(true);
                        return;
                    }
                }
            }
        }
        System.out.println(false);
    }
    public static boolean checkword(char[][] board,int cr,int cc,String word,int idx){
        if(idx == word.length())
            return true;
        if(cr<0 || cr>=board.length || cc<0 || cc>=board[0].length || board[cr][cc]!=word.charAt(idx))
            return false;

        board[cr][cc] = '*';                                // Blocking that element

        int[] r = {0,-1,0,1};
        int[] c = {1,0,-1,0};
        for(int i=0;i<r.length;i++){
            boolean ans = checkword(board,cr+r[i],cc+c[i],word,idx+1);
            if(ans)
                return true;
        }
        board[cr][cc] = word.charAt(idx);                   // Backtrack --> undo the changes
        return false;
    }
}
