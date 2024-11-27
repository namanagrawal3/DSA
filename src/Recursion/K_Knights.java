package Recursion;

public class K_Knights {
    static int count = 0;
    public static void main(String[] args) {
        int n = 3;
        boolean[][] board = new boolean[n][n];
        checkPosition(board,0,0,n);
        System.out.println(count);
    }
    public static void checkPosition(boolean[][] board,int row,int col,int knights){
        if(knights == 0){
            display(board);
            count++;
            return;
        }
        if(row == board.length)
            return;
        if(col == board[0].length){
            col = 0;
            row++;
        }
        if(isPossible(board,row,col)){
            board[row][col] = true;
            checkPosition(board,row,col+1,knights-1);
            board[row][col] = false;
        }
        checkPosition(board,row,col+1,knights);
    }
    public static boolean isPossible(boolean[][] board,int row,int col){
        int[] r = {-2,-2,-1,-1};
        int[] c = {-1,1,-2,2};
        for(int i=0;i<r.length;i++){
            int x = row+r[i];
            int y = col+c[i];
            if(x>=0 && x<board.length && y>=0 && y<board[0].length && board[x][y] == true)
                return false;
        }
        return true;
    }
    public static void display(boolean[][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
    }
}
