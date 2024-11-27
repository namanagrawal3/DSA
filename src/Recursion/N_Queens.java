package Recursion;

public class N_Queens {
    public static void main(String[] args){
        int n = 4;
        boolean[][] board = new boolean[n][n];
        placeQueen(board,n,0);
    }
    public static void placeQueen(boolean[][] board,int tq,int row){
        if(tq==0){
            display(board);
            return;
        }
        if(row == board.length)
            return;

        for(int col=0;col<board[0].length;col++){
            if(isPossible(board,row,col)){
                board[row][col] = true;
                placeQueen(board,tq-1,row+1);
                board[row][col] = false;
            }
        }
    }
    public static void display(boolean[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
    public static boolean isPossible(boolean[][] board,int row,int col){
        int r = row;
        while(r>=0){
            if(board[r][col] == true)               // check top straight
                return false;
            r--;
        }
        r = row;
        int c = col;
        while(r>=0 && c>=0){
            if(board[r][c] == true)               // check top left diagonal
                return false;
            r--;
            c--;
        }
        r = row;
        c = col;
        while(r>=0 && c<board[0].length){
            if(board[r][c] == true)               // check top right diagonal
                return false;
            r--;
            c++;
        }
        return true;
    }
}
