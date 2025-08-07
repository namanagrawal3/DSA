package Recursion_Backtracking;

public class Print_increasing_seq {
    public static void main(String[] args) {
        int n = 5;
        print(n);
    }
    public static void print(int n){
        if (n == 0)
            return;                                             // Head Recursion

        print(n-1);
        System.out.println(n);
    }
}
