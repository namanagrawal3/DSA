package Recursion_Backtracking;

public class Pow_logN {
    public static void main(String[] args) {
        int a = 3;
        int n = 5;

        System.out.println(pow(a, n));
    }
    public static int pow(int a, int n) {
        if (n == 0)
            return 1;

        int ans = pow(a, n/2);
        ans = ans * ans;
        if (n % 2 != 0)
            ans = ans * a;

        return ans;
    }
}
