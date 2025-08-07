package Recursion_Backtracking;

public class Print_decreasing_seq {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
    public static void print(int n){
        if (n == 0)
            return;                                        // Tail Recursion  -->  last statement is the recursive call

        System.out.println(n);
        print(n-1);
    }
}
