package Divide_and_Conquerer;

import java.util.Arrays;

public class Sieve_of_Eratosthenes {                              // Prime-Sieve Algorithm
    public static void main(String[] args) {
        int n = 100;

        boolean[] prime = new boolean[n+1];                       // Time Complexity: N*log(log(N))
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

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if(prime[i]) {
                System.out.print(i + " ");
                count++;
            }
        }

        System.out.println();
        System.out.println(count);
    }
}
