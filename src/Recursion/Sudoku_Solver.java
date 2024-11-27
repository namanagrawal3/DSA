package Recursion;

public class Sudoku_Solver {
    public static void main(String[] args) {
        int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
        solve(grid,0,0);
    }
    public static void solve(int[][] board,int row,int col){
        if(col == 9){
            row++;
            col = 0;
        }
        if(row == 9) {
            display(board);
            return;
        }
        if(board[row][col] != 0)
            solve(board,row,col+1);
        else{
            for(int val=1;val<=9;val++){
                if(isPossible(board,row,col,val)){
                    board[row][col] = val;
                    solve(board,row,col+1);
                    board[row][col] = 0;
                }
            }
        }
    }
    public static boolean isPossible(int[][] board,int row,int col,int val){
        int c=0;
        while(c<9){
            if(board[row][c] == val)
                return false;
            c++;
        }
        int r=0;
        while(r<9){
            if(board[r][col] == val)
                return false;
            r++;
        }
        r = row - row%3;
        c = col - col%3;
        for(int i=r;i<r+3;i++){
            for(int j=c;j<c+3;j++){
                if(board[i][j] == val)
                    return false;
            }
        }
        return true;
    }
    public static void display(int[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
