package _2D_Arrays;

public class Game_of_Life {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        int row = board.length;
        int col = board[0].length;

        int[] x = {1,1,0,-1,-1,-1,0,1};                     // x-coordinates of 8 neighbours
        int[] y = {0,1,1,1,0,-1,-1,-1};                     // y-coordinates of 8 neighbours

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int live_neighbour = 0;
                for(int k=0;k<8;k++){
                    int x_neigh = i+x[k];
                    int y_neigh = j+y[k];
                    if(isValidNeigh(x_neigh,y_neigh,board) && Math.abs(board[x_neigh][y_neigh])==1)
                        live_neighbour++;
                }
                if(board[i][j] == 1){
                    if(live_neighbour<2 || live_neighbour > 3)
                        board[i][j] = -1;
                }
                else{
                    if(live_neighbour == 3)
                        board[i][j] = 2;
                }
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j] >= 1)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static boolean isValidNeigh(int x,int y,int[][] board){
        int row = board.length;
        int col = board[0].length;
        return x<row && x>=0 && y<col && y>=0;
    }
}
