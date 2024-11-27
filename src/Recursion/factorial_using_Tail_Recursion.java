package Recursion;

public class factorial_using_Tail_Recursion {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(fact(n,1));
    }
    public static int fact(int n,int ans){
        if(n == 0)
            return ans;
        return fact(n-1,ans*n);
    }
}
