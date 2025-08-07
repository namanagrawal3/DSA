package Divide_and_Conquerer;

public class Check_Prime {
    public static void main(String[] args) {
        int n = 43;
        System.out.println(checkPrime(n));
    }
    public static boolean checkPrime(int n) {
        if (n < 2)
            return false;

        for (int i = 2; i*i <= n; i++) {                // O(sqrt(N))
            if (n % i == 0)
                return false;
        }

        return true;
    }
}
