package Recursion;

public class power_of_no {
    public static void main(String[] args) {
        // a^n
        int a = 3;
        int n = 4;
        System.out.println(power(a,n));
    }
    public static int power(int a,int n){
        if(n == 0)                                          // Head Recursion
            return 1;
        int ans = power(a,n-1);
        return ans*a;
    }
}
