package Divide_and_Conquerer;
import java.util.*;

public class Segmented_Sieve {
    public static void main(String[] args) {
        int m = 4, n = 15;

        List<Integer> ll = primeSeive((int)Math.sqrt(n));
        boolean[] prime = new boolean[n-m+1];
        Arrays.fill(prime, true);

        for (int p : ll) {
            int low = m/p;
            if (low <= 1)
                low = 2*p;
            else if (m%p != 0)
                low = (low*p) + p;
            else
                low = low*p;

            for (; low <= n; low += p) {
                prime[low-m] = false;
            }
        }

        if (m == 1)
            prime[0] = false;

        List<Integer> ans = new ArrayList<>();
        for (int i = m; i <= n; i++) {
            if (prime[i-m])
                ans.add(i);
        }
        System.out.println(ans);
    }
    public static List<Integer> primeSeive(int n) {
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;

        for (int i = 2; i*i <= n; i++) {
            if (prime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        List<Integer> p = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                p.add(i);
        }
        return p;
    }
}
