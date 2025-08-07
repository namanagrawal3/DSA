package Recursion_Backtracking;

public class Tower_of_Hanoi {
    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n, 'A', 'B', 'C');             // (2^n - 1) moves
    }
    public static void towerOfHanoi(int n, char src, char des, char hlp) {
         if (n == 0)
             return;

         towerOfHanoi(n-1, src, hlp, des);          // Move top (n-1) disc from src to hlp
         System.out.println("Move "+ n +"th disk from "+ src +" to "+ des);
         towerOfHanoi(n-1, hlp, des, src);          // Move those (n-1) disc from hlp to des
    }
}
