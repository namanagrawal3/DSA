package Recursion;

public class Josephus_Problem {
    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        int ans = solve(n,k);
        System.out.println(ans+1);                  // 1-based indexing
    }
    public static int solve(int n,int k){
        if(n == 1)
            return 0;
        int ans = solve(n-1,k);
        return (ans+k)%n;
    }
}
