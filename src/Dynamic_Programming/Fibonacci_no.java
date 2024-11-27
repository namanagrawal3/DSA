package Dynamic_Programming;

public class Fibonacci_no {
    public static void main(String[] args) {
        int n = 5;

        System.out.println(fib(n));

        int[] dp = new int[n+1];
        System.out.println(fibTD(n, dp));

        System.out.println(fibBU(n));
    }
    public static int fib(int n) {              // without DP
        if (n <= 1)
            return n;

        int f1 = fib(n-1);
        int f2 = fib(n-2);

        return f1+f2;
    }
    public static int fibTD(int n, int[] dp) {  // Top-Down (Memoization) approach
        if (n <= 1)
            return n;

        if (dp[n] != 0)
            return dp[n];

        int f1 = fibTD(n-1, dp);
        int f2 = fibTD(n-2, dp);

        return dp[n] = f1+f2;
    }
    public static int fibBU(int n) {             // Bottom-Up (Tabulation) approach
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
