package Recursion;

public class print_names {
    public static void main(String[] args) {
        int n = 5;
        fun(n);
    }
    public static void fun(int n){
        if(n == 0)                                      // Tail Recursion
            return;
        System.out.println("Naman");
        fun(n-1);
    }
}
