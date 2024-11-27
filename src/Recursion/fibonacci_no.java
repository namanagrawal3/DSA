package Recursion;

public class fibonacci_no {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fibonacci(n));
    }
    public static int fibonacci(int n){
        if(n <= 1)
            return n;
        int f1 = fibonacci(n-1);
        int f2 = fibonacci(n-2);
        return f1+f2;
    }
}
