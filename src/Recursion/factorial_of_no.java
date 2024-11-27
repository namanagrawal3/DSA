package Recursion;

public class factorial_of_no {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(fact(n));
    }
    public static int fact(int n){                          // Head Recursion
        if(n == 0)
            return 1;
        int ans = fact(n-1);
        return n*ans;
    }
}
