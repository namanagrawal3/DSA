package Recursion;

public class queen_Combination {
    public static void main(String[] args) {
        int n = 4;
        int queens = 2;
        boolean[] board = new boolean[n];
        printPermutation(n,queens,board,0,"",0);
    }
    public static void printPermutation(int n,int tq,boolean[] board,int qpsf,String ans,int idx){
        // n ---> boxes in board
        // tq ---> total queens
        // qpsf ---> queens placed so far
        if(tq == qpsf){
            System.out.println(ans);
            return;
        }
        for(int i=idx;i<n;i++){
            if(board[i] == false){
                board[i] = true;
                printPermutation(n,tq,board,qpsf+1,ans+"b"+i+"q"+qpsf+" ",i+1);
                board[i] = false;                         // Undo the change done ----> Backtracking
            }
        }
    }
}
