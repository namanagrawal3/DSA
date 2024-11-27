package Recursion;

public class sum_of_N_no {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(sumOfNumber(n));
    }
    public static int sumOfNumber(int n){                   // Head Recursion
        if(n == 0)
            return 0;
        int ans = sumOfNumber(n-1);
        return ans+n;
    }
}
