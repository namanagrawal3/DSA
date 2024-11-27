package Recursion;

public class queen_Permutation {
    public static void main(String[] args) {
        int board = 4;
        int queens = 2;
        boolean[] visited = new boolean[board];
        printPermutation(board,queens,visited,0,"");
    }
    public static void printPermutation(int n,int tq,boolean[] visited,int qpsf,String ans){
        // n ---> boxes in board
        // tq ---> total queens
        // qpsf ---> queens placed so far
        if(tq == qpsf){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                visited[i] = true;
                printPermutation(n,tq,visited,qpsf+1,ans+"b"+i+"q"+qpsf+" ");
                visited[i] = false;                         // Undo the change done ----> Backtracking
            }
        }
    }
}
