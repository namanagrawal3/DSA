package Recursion_Backtracking;

public class Queen_Combination {
    public static void main(String[] args) {
        int n = 4;
        int queens = 2;
        printCombination(n, queens,0,"",0);
    }
    public static void printCombination(int n, int tq, int qpsf, String ans, int idx) {
        // n ---> boxes in board
        // tq ---> total queens
        // qpsf ---> queens placed so far

        if (qpsf == tq) {
            System.out.println(ans);
            return;
        }

        for (int i = idx; i < n; i++) {
            printCombination(n, tq,qpsf+1,ans+"b"+i+"q"+qpsf+" ",i+1);
        }
    }
}
